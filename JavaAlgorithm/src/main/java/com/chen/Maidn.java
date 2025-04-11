
import java.util.*;
/**
 * 题目背景
问题描述如下：

下大雨啦，今天的活动课只能在室内上了！同学们把n个座位围成了一个圈，编号为1,2,…,n,1,2,…)。m位同学挑选了自己喜欢的位置坐下，保证全部同学都有座位坐，一个座位上至多只坐了一个人。体育老师来给大家送礼物了，他想要找到这样一个位置，使得全部人到礼物的距离之和最小。具体来说，假设第i个同学坐在第a_i个座位上，那么礼物要放在这样一个座位j上，使得


输入描述
第一行输入两个整数m,n(1≤n≤10^5,1≤m≤2*10^5)，代表座位的数量和同学的数量。第二行输入m个不同的整数a_1,a_2,…,a_m(1≤a_i≤n)，代表每个同学所坐的位置编号。

输出描述
在一行上输出一个整数，代表礼物放置的最佳座位编号。如果在多个位置使得
∑
i
=
1
m
min
⁡
{
∣
j
−
a
i
∣
,
∣
a
i
+
n
−
j
∣
}
∑ 
i=1
m
​
 min{∣j−a 
i
​
 ∣,∣a 
i
​
 +n−j∣} 最小，则输出最小的位置编号即可。
 */
public class Maidn {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 读取 n 和 m 的值
        int n = input.nextInt();
        int m = input.nextInt();

        // 读取 m 个学生的座位号
        int[] seats = new int[m];
        for (int i = 0; i < m; i++) {
            seats[i] = input.nextInt();
        }

        // 计算最佳座位位置
        int bestPosition = findBestPosition(seats, n);

        // 输出结果
        System.out.println(bestPosition);
    }

    private static int findBestPosition(int[] seats, int n) {
        // 使用 TreeMap 存储每个位置的权重，自动排序
        Map<Integer, Integer> positionWeight = new TreeMap<>();

        // 计算 n+1 到 2n 个位置的权重
        for (int seat : seats) {
            int relativeSeat = seat - 1; // 转换为从 0 开始的索引
            // for (int j = n + 1; j <= 2 * n; j++) {
            for (int j = 0; j < n; j++) {
                int distance = Math.min(Math.abs(j - relativeSeat), Math.abs(relativeSeat + n - j));

                positionWeight.put(j, positionWeight.getOrDefault(j, 0) + distance);
            }
        }

        // 找到权重最小的位置
        int minWeight = Integer.MAX_VALUE;
        int bestPosition = -1;
        for (Map.Entry<Integer, Integer> entry : positionWeight.entrySet()) {
            // System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue() < minWeight) {
                minWeight = entry.getValue();
                bestPosition = entry.getKey() + 1;
            }
        }

        return bestPosition;
    }
}
