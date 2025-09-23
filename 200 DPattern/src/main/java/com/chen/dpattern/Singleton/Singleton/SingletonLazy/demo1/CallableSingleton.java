package com.chen.dpattern.Singleton.Singleton.SingletonLazy.demo1;



import java.util.concurrent.Callable;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demoLaste.demo1.Single.Singleton.demo3
 * @className demoLaste.demo1.Single.Singleton.demo3.CallableSingleton
 * @date 2024/12/7 16:49
 * @description @todo
 */
public class CallableSingleton implements Callable<Singleton> {

    @Override
    public Singleton call() throws Exception {
        return Singleton.getInstance();
    }
}
