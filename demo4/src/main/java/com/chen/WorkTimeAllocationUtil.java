package com.chen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 生产工时分摊算法工具类 核心逻辑：按标准工时占比分摊并行任务工时，精准识别非整点并行时段
 */
public class WorkTimeAllocationUtil {

    /**
     * 生产任务实体类 包含任务基础信息、时间信息、标准工时信息
     */
    public static class ProductionTask {

        private final String taskId;          // 任务ID
        private final LocalDateTime startTime;// 任务开始时间
        private final LocalDateTime endTime;  // 任务结束时间
        private final BigDecimal standardTimePerUnit; // 标准单件工时（分钟/件）
        private final int quantity;           // 任务产量
        private final BigDecimal totalStandardTime; // 任务标准总工时（分钟）
        private final BigDecimal actualStandardTime; // 任务实际标准工时（分钟）

        // 构造方法：初始化时自动计算标准总工时
        public ProductionTask(String taskId, LocalDateTime startTime, LocalDateTime endTime,
                BigDecimal standardTimePerUnit, int quantity) {
            this.taskId = taskId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.standardTimePerUnit = standardTimePerUnit;
            this.quantity = quantity;
            // 计算标准总工时：标准单件×产量，保留2位小数
            this.totalStandardTime = standardTimePerUnit.multiply(BigDecimal.valueOf(quantity))
                    .setScale(2, RoundingMode.HALF_UP);
            this.actualStandardTime = BigDecimal.valueOf(endTime.toLocalTime().toSecondOfDay() - startTime.toLocalTime().toSecondOfDay())
                    .divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);
        }

        // Getter方法
        public String getTaskId() {
            return taskId;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public BigDecimal getTotalStandardTime() {
            return totalStandardTime;
        }

        public BigDecimal getActualStandardTime() {
            return actualStandardTime;
        }

        public int getQuantity() {
            return quantity;
        }

        public BigDecimal getStandardTimePerUnit() {
            return standardTimePerUnit;
        }

    }

    /**
     * 核心方法：按标准工时占比分摊并行任务工时
     *
     * @param tasks 同一员工、同一天的所有生产任务
     * @return 各任务的最终分摊工时（分钟），key=任务ID，value=分摊工时
     */
    public static Map<String, BigDecimal> allocateByStandardTime(List<ProductionTask> tasks) {
        // 1. 校验输入：任务列表为空时直接返回空结果
        if (tasks == null || tasks.isEmpty()) {
            return new HashMap<>();
        }

        // 2. 收集所有时间点（开始+结束），去重并按时间排序
        Set<LocalDateTime> allTimePoints = new TreeSet<>();
        for (ProductionTask task : tasks) {
            allTimePoints.add(task.getStartTime());
            allTimePoints.add(task.getEndTime());
        }
        List<LocalDateTime> timePoints = new ArrayList<>(allTimePoints);

        // 3. 初始化各任务的分摊工时（初始值为0）
        Map<String, BigDecimal> taskAllocatedTime = new HashMap<>();
        for (ProductionTask task : tasks) {
            taskAllocatedTime.put(task.getTaskId(), BigDecimal.ZERO);
        }

        // 4. 遍历每个时间区间，计算分摊工时
        for (int i = 0; i < timePoints.size() - 1; i++) {
            LocalDateTime intervalStart = timePoints.get(i);
            LocalDateTime intervalEnd = timePoints.get(i + 1);

            // 4.1 计算当前区间的时长（秒→分钟，保留4位小数）
            long seconds = Duration.between(intervalStart, intervalEnd).getSeconds();
            BigDecimal intervalDuration = BigDecimal.valueOf(seconds)
                    .divide(BigDecimal.valueOf(60), 4, RoundingMode.HALF_UP);

            // 4.2 筛选当前区间内的所有进行中任务
            List<ProductionTask> ongoingTasks = tasks.stream()
                    .filter(task -> !task.getStartTime().isAfter(intervalStart)
                    && !task.getEndTime().isBefore(intervalEnd))
                    .collect(Collectors.toList());

            // 4.3 处理单独任务（无需分摊，直接累加时长）
            if (ongoingTasks.size() == 1) {
                ProductionTask singleTask = ongoingTasks.get(0);
                BigDecimal currentTime = taskAllocatedTime.get(singleTask.getTaskId());
                taskAllocatedTime.put(singleTask.getTaskId(),
                        currentTime.add(intervalDuration).setScale(2, RoundingMode.HALF_UP));
            } // 4.4 处理并行任务（按标准总工时占比分摊）
            else if (ongoingTasks.size() >= 2) {
                // 计算并行任务的标准总工时之和
                BigDecimal totalStandardTime = ongoingTasks.stream()
                        .map(ProductionTask::getTotalStandardTime)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                // 按占比分摊当前区间时长到每个并行任务
                for (ProductionTask task : ongoingTasks) {
                    BigDecimal ratio = task.getTotalStandardTime()
                            .divide(totalStandardTime, 4, RoundingMode.HALF_UP);
                    BigDecimal allocated = intervalDuration.multiply(ratio)
                            .setScale(2, RoundingMode.HALF_UP);
                    BigDecimal currentTime = taskAllocatedTime.get(task.getTaskId());
                    taskAllocatedTime.put(task.getTaskId(), currentTime.add(allocated));
                }
            }
        }

        return taskAllocatedTime;
    }

    /**
     * 测试方法：验证分摊算法的正确性
     */
    public static void main(String[] args) {
        // 1. 构造测试任务（对应示例中的任务A/B/C）
        LocalDateTime aStart = LocalDateTime.of(2024, 1, 8, 8, 5, 0);
        LocalDateTime aEnd = LocalDateTime.of(2024, 1, 8, 12, 10, 0);
        ProductionTask taskA = new ProductionTask("A", aStart, aEnd, new BigDecimal("10"), 10);

        LocalDateTime bStart = LocalDateTime.of(2024, 1, 8, 8, 6, 0);
        LocalDateTime bEnd = LocalDateTime.of(2024, 1, 8, 10, 8, 0);
        ProductionTask taskB = new ProductionTask("B", bStart, bEnd, new BigDecimal("5"), 20);

        LocalDateTime cStart = LocalDateTime.of(2024, 1, 8, 10, 7, 0);
        LocalDateTime cEnd = LocalDateTime.of(2024, 1, 8, 12, 10, 0);
        ProductionTask taskC = new ProductionTask("C", cStart, cEnd, new BigDecimal("8"), 15);

        // 2. 执行分摊计算
        List<ProductionTask> tasks = Arrays.asList(taskA, taskB, taskC);
        Map<String, BigDecimal> allocationResult = allocateByStandardTime(tasks);

        // 3. 输出结果
        System.out.println("=== 工时分摊结果 ===");
        for (Map.Entry<String, BigDecimal> entry : allocationResult.entrySet()) {
            System.out.println("任务" + entry.getKey()
                    + "（标准工时：" + entry.getKey() + "）分摊工时：" + entry.getValue() + "分钟");
        }

        for (ProductionTask task : tasks) {
            System.out.println("任务" + task.getTaskId()
                    + "开始时间" + task.getStartTime() + "）"
                    + "结束时间" + task.getEndTime() + "）"
                    + "（实际工时：" + task.getActualStandardTime() + "）"
                    + "（标准工时：" + task.getTotalStandardTime() + "）分摊工时：" + allocationResult.get(task.getTaskId()) + "分钟");
        }

        // 4. 验证总工时
        BigDecimal total = allocationResult.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("总分摊工时：" + total + "分钟（验证：8:05-12:10实际时长245分钟）");
    }
}
