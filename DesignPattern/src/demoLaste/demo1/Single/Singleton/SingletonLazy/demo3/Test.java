package demoLaste.demo1.Single.Singleton.SingletonLazy.demo3;

//import demoLaste.demo1.Single.SingletonLazy.demo3.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.Pohuai.demo2
 * @className demoLaste.demo1.Single.Pohuai.demo2.Client
 * @date 2024/10/22 16:36
 * @description 发射破坏单例模式
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1. 获取字节码对象
        Class clazz = Singleton.class;

        // 2. 获取无参构造方法
        Constructor cons = clazz.getDeclaredConstructor();
        // 3. 取消访问检查
        cons.setAccessible(true);

        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();
        // 结果 破坏了单例模式
        System.out.println(s1== s2);
    }

}
