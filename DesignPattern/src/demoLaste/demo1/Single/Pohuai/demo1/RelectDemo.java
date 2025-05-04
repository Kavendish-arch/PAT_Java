package demoLaste.demo1.Single.Pohuai.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RelectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //测试类中的代码：
        //需求2：
        //获取带参构造，并创建对象
        //1.获取整体的字节码文件对象
        Class clazz = Class.forName("demoLaste.demo1.Single.Pohuai.demo1.Singleton");
        //2.获取有参构造方法
        Constructor con = clazz.getDeclaredConstructor();
        //3.临时修改构造方法的访问权限（暴力反射）
        con.setAccessible(true);
        //4.直接创建对象
        Singleton s = (Singleton) con.newInstance();

        // 存在两个对象
        System.out.println(s);
        System.out.println(Singleton.getInstance());
        System.out.println(s == Singleton.getInstance());
    }
}
