package demoLaste.demo1.Single.Singleton.SingletonLazy.demo3;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.SingletonLazy.demo3
 * @className demoLaste.demo1.Single.SingletonLazy.demo3.demoLaste.demo1.Single.Singleton
 * @date 2024/10/22 16:18
 * @description 单例模式静态内部类
 */
public class Singleton {

    private static boolean flag = false;
    private Singleton(){
        /**
         * 反射破解方法
         */
        synchronized (Singleton.class)
        {

        if(flag)
        {
            throw new RuntimeException("单例模式不允许多个实例");
        }
        flag = true;
        }
    }

    // 私有化构造函数
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    // 静态内部类
    private static class SingletonHolder{

        private static final Singleton INSTANCE = new Singleton();
    }
}
