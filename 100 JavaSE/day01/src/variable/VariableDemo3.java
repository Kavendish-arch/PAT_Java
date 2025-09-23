package variable;

public class VariableDemo3 {

    public static void main(String[] args) {



        // 4. 输出
        printVariable();
    }

    /**
     * 打印不同进制的整数变量
     *
     * 此方法展示了如何在Java中声明和使用不同进制（二进制、十六进制、八进制和十进制）的整数变量
     * 它首先创建了四个整数变量，分别用不同的进制表示，然后打印它们的值
     * 最后，它还展示了如何重新赋值给一个变量，并再次打印其值
     */
    public static void printVariable() {

        // 1. 创建变量
        // 使用二进制表示的整数
        int a = 0B11111000;
        // 使用十六进制表示的整数
        int b = 0XFA;
        // 使用八进制表示的整数
        int c = 0141;
        // 使用十进制表示的整数
        int d = 100;
        // 打印所有变量的值
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


    }
}
