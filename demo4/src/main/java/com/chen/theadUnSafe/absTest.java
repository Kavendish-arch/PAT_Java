package com.chen.theadUnSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* @projectName PAT_Java
* @package com.chen.theadUnSafe
* @className com.chen.theadUnSafe.pu

* @author chenyingtao
* @date 2025/4/20 21:50
* @version 1.0
* @description @todo 
*/
public abstract class absTest {
    public void bar(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        foo(sdf);
    }
    public abstract void foo(SimpleDateFormat sdf);

    public static void main(String[] args) {
        new absTest() {
            @Override
            public void foo(SimpleDateFormat sdf) {
                String dateStr = "2025-04-20 21:50:00";
                for(int i = 0; i < 10; i++){
                    new Thread(()->{
                        try {
                            sdf.parse(dateStr);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }
            }
        }.bar();
    }
}
