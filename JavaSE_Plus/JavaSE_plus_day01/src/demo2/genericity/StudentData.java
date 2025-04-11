package demo2.genericity;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2genericity
 * @className demo2genericity.StudentData
 * @date 2024/11/13 20:01
 * @description 实现类
 */
class Student{
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
public class StudentData implements Data<Student>{

    @Override
    public void add(Student data) {

    }

    @Override
    public void delete(Student data) {

    }

    @Override
    public void update(Student data) {

    }

    @Override
    public Student query(Student data) {
        return null;
    }
}
