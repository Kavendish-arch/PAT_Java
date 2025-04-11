//package com.chen.moni;//package com.chen.moni;

/**
* @projectName PAT
* @package com.chen.moni
* @className com.chen.moni.test

* @author chenyingtao
* @date 2025/3/30 20:24
* @version 1.0
* @description @todo 
*/
enum AccountType{
    SAVING, FINED, CURREN;
    private AccountType(){
        System.out.println("it is a account type");
    }
}
public class test {
    public static void main(String[] args) {
//        double d1 = -0.5;
//        System.out.println(Math.ceil(d1));
//        System.out.println(Math.floor(d1));
        System.out.println(AccountType.FINED);
    }
}
