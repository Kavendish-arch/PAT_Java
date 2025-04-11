package demo1.Exception.my;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1.Exception.my
 * @className demo1.Exception.my.Main
 * @date 2024/11/13 13:39
 * @description 测试类
 */
public class Main {
    public static void main(String[] args){

        System.out.println("程序开始");
        try{
            saveAge(-1);
            saveAge(200);
            saveAge(18);
        }
        catch (MyException e)
        {
            e.printStackTrace();
            System.out.println("捕获到异常");
        }

        System.out.println("程序结束");
    }

    public static void saveAge(int age) throws MyException{
        if(age < 0 || age > 200)
        {
            throw new MyException("年龄不合法");
        }
        System.out.println("年龄：" + age);
        System.out.println("年龄合法");
    }
}
