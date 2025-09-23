package com.chen.dpattern.Singleton.Pohuai.demo1;

import com.chen.dpattern.Singleton.Singleton.SingletonLazy.demo2.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.Pohuai.demo1
 * @className demoLaste.demo1.Single.Pohuai.demo1.Client
 * @date 2024/10/22 16:28
 * @description 测试用反序列化破坏单例模式
 */
public class Client {
    public static void main(String[] args) throws Exception {
        /**
         * 对象不同
         */
            writeObject2File();
            readObjectFromFile();
    }

    public static void writeObject2File() throws Exception{
        // 1. create a instance
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
        // 2. write object to file
        oos.writeObject(instance);
        // 3. close
        oos.close();
    }

    public static void readObjectFromFile() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));

        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);
        System.out.println(Singleton.getInstance());
        System.out.println(instance == Singleton.getInstance());
        ois.close();
    }
}
