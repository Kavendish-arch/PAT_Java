package com.chen.threadSafe.safeclass;

import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;

/**
* @projectName PAT_Java
* @package com.chen.threadSafe.safeclass
* @className com.chen.threadSafe.safeclass.Main

* @author chenyingtao
* @date 2025/4/20 21:30
* @version 1.0
* @description @todo 
*/
public class Main {
    public static void main(String[] args) {
        //不可变类型
        String s = "abc";
        Integer i = 1;
        // 线程安全方法
        StringBuffer sb = new StringBuffer("abc");
        Random r = new Random();
        Vector v = new Vector();
        Hashtable<String, String> h = new Hashtable();
         h.put("a", "a");
    }
}
