package com.chen.threadSafe.safeclass;

import java.util.Hashtable;

/**
* @projectName PAT_Java
* @package com.chen.threadSafe.safeclass
* @className com.chen.threadSafe.safeclass.MainTestHashTable

* @author chenyingtao
* @date 2025/4/20 21:33
* @version 1.0
* @description @todo 
*/
public class MainTestHashTable {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> h = new Hashtable();
        Thread t1 = new Thread(()->{
            if(h.get("a") == null)  {
                h.put("a", "a");
            }
        });

        Thread t2 = new Thread(()->{
            if(h.get("a") == null)  {
                h.put("a", "b");
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(h.get("a"));
    }
}
