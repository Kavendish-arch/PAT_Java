package demo1.Exception.my;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1.Exception.my
 * @className demo1.Exception.my.MyException
 * @date 2024/11/13 13:38
 * @description 自定义编译异常
 * 自定义编译异常
 * 1. 继承Exception
 * 2. 构造方法重写 Exception的构造器
 */
public class MyException extends Exception{

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
