package demo1.RuntimeException;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1RuntimeException
 * @className demo1RuntimeException.ExceptionDemo2
 * @date 2024/11/13 13:29
 * @description 自定义异常
 */
public class ExceptionDemo2 {

    public static int div(int a, int b) throws Exception {
        if (b == 0) {
            System.out.println("除数不能为0");

//            return -1; // 返回异常
//            throw new RuntimeException("");
            throw new Exception("除数不能为0");
        }
        return a / b;
    }

    public static int test1() {
        try {
            System.out.println("try block");

//            int i = 1 / 0;
            return 0;
        } catch (Exception e) {
            System.out.println("catch block");
            return 1;
        } finally {
            System.out.println("finally block");
            return 2;
        }
    }

    public static int test2() {
        int i = 999;
        try {
            System.out.println("try block");

//            i = 1 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("catch block");

            i = 100;
            return i;
        } finally {
            System.out.println("finally block");

            i = 200;
        }
    }

    public static int get() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        int a = 10;

        int b = 0;

        try {
            int c = div(a, b);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序结束");
        }

        System.out.println(get());
        System.out.println(test1());
        System.out.println(test2());
    }
}
