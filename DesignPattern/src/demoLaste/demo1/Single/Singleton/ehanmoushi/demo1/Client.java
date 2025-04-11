package demoLaste.demo1.Single.Singleton.ehanmoushi.demo1;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.Singleton.demo1
 * @className demoLaste.demo1.Single.Singleton.demo1.Client
 * @date 2024/10/22 15:15
 * @description 单例模式测试
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        Singleton singleton1 = Singleton.getInstance();

        // 判断是否是同一个对象
        System.out.println("判断是否相同");
        System.out.println(instance == singleton1);
    }
}
