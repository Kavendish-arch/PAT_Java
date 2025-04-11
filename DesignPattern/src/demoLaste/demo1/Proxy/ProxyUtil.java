package demoLaste.demo1.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName Reflection
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.ProxyUtil
 * @date 2024/10/24 13:08
 * @description 代理对象工具类
 */
public class ProxyUtil {
    public static <T> T getProxyInstance(T obj) {
        /***
         * 1. 参数 用于执行哪个类加载器去加载生成的代理类
         * 2. 需要代理的接口, 获取当前对象的实现接口，代理类需要实现哪些接口
         * 3. 用于指定代理类如何去实现接口的方法
         */
        T proxy = (T) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                obj.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         * 1. proxy: 代理对象，一般不用
                         * 2. method: 要调用的方法
                         * 3. args: 调用方法时传入的参数 正在被代理的方法的参数
                         */
                        String methodName = method.getName();
                        // 该方法执行前需要的逻辑
                        Long start = System.currentTimeMillis();
                        // 真正干活的
                        Object invoke = method.invoke(obj, args);
                        // 该方法执行后需要的逻辑
                        Long end = System.currentTimeMillis();

                        System.out.println(end-start);
                        return invoke;
                    }
                }

        );
        return proxy;
    }
}
