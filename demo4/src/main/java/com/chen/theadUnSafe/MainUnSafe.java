package com.chen.theadUnSafe;

import java.sql.Connection;

/**
* @projectName PAT_Java
* @package com.chen.theadUnSafe
* @className com.chen.theadUnSafe.MainUnSafe

* @author chenyingtao
* @date 2025/4/20 21:46
* @version 1.0
* @description @todo 
*/
public class MainUnSafe {
}

class UserServiceImpl{
    public void update(){
        // 局部变量线程安全
        UserDao userDao = new UserDao();
        userDao.update();
        System.out.println();
    }

    public void test2(){

    }
}

class UserDao {
    private Connection connection = null;
    public void update(){
        System.out.println("UserDao update");
    }

}
