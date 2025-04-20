package com.chen.threadSafe;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @projectName PAT_Java
* @package com.chen.threadSafe
* @className com.chen.threadSafe.MyServlet

* @author chenyingtao
* @date 2025/4/20 21:36
* @version 1.0
* @description @todo 
*/
// servlet 运行在tomcat中，就一个
public class MyServlet {
    Map<String, String> map = new HashMap<>();
    //不可变，线程安全
    String name = "chen";
    // 不可变，线程安全
    final String name2 = "chen";
    // 不安全
    Date date = new Date();
    // 不安全
    final Date date2 = new Date();

    private UserService userService;

    public void doGet() {
        // 线程不安全
        map.put("name", "chen");
        // 不安全
        date.setTime(System.currentTimeMillis());
        // 不安全
        date2.setTime(System.currentTimeMillis());
        // 不安全
        name = "chen";
        // 不安全
//        name2 = "chen";
        // 不安全
        userService.updateUser();
    }

}

class MyAspect{
    private long start = 0L;

    public void before() {
        // 环绕通知
        // 前置通知
        start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
    }

    public void after() {
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}

interface UserService {
    void updateUser();
}
class UserServiceImpl implements UserService {
    private int count = 0;

    @Override
    public void updateUser() {
        // 更新用户
        count++;
    }
}
