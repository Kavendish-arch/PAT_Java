package demo2.genericity;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2genericity
 * @className demo2genericity.GenricDemo3
 * @date 2024/11/13 19:58
 * @description 泛型接口的作用
 */
public class GenricDemo3 {
    /**
     * 需求，针对学生数据、老师数据进行增删改查
     */
    public static void main(String[] args) {
        StudentData studentData = new StudentData();
        studentData.add(new Student("小明", 18));
        studentData.delete(new Student("小明", 18));
        studentData.update(new Student("小明", 18));
        studentData.query(new Student("小明", 18));

    }
}
