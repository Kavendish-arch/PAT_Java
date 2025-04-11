package demo1.RuntimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1RuntimeException
 * @className demo1RuntimeException.ExceptionDemo1
 * @date 2024/11/13 13:16
 * @description 运行时异常
 */
public class ExceptionDemo1 {
    public static void main(String[] args) throws ParseException {
//        printArray();
        print();
    }
    public static void printArray() {
        int[] a = new int[5];
        // 访问数组越界
        System.out.println(a[5]);

        // 数字操作异常

        // 空指针异常
    }

    public static void print() throws ParseException {
        String str = "2024-07-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str); // 编译时异常
        try {
            System.out.println(sdf.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
