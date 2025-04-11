package demo1.RuntimeException.my;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1.RuntimeException.my
 * @className demo1.RuntimeException.my.MyRException
 * @date 2024/11/13 13:45
 * @description 自定义运行时异常
 */
public class MyRException extends RuntimeException{
    public MyRException()
    {

    }

    public MyRException(String message)
    {
        super(message);
    }
}
