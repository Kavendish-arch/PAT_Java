package demo1;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo1
 * @className demo1.ExceptionDemo6
 * @date 2024/11/13 13:55
 * @description 异常处理方式2
 * 最外层捕获异常后重新处理
 */
public class ExceptionDemo6 {
    public static void main(String[] args) throws Exception {
        System.out.println("欢迎使用商品管理系统");
        while (true) {
            try {
                double price = userInputPrice();
                System.out.println("价格输入正确");
                System.out.println("商品的价格是：" + price);
            } catch (Exception e) {
                System.out.println("价格输入不正确");
            }
            System.out.println("程序结束");
        }
    }
    public static double userInputPrice() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品价格：");
        return sc.nextDouble();
    }
}
