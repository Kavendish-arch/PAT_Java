package demo1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1
 * @className demo1.ExceptionDemo5
 * @date 2024/11/13 13:52
 * @description 异常处理方式1 . 底层抛出，顶层捕获
 *
 */
public class ExceptionDemo5 {
    public static void main(String[] args) {
        try {

            show();
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("捕获到异常");
        }
    }

    public static void show() throws Exception{
        String str = "hello";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        System.out.println(date);

        InputStream is = new FileInputStream("D:/mei.png");
    }
}
