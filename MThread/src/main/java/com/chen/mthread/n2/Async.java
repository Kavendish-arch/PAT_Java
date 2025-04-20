package com.chen.mthread.n2;

import com.chen.mthread.n2.util.FileReader;

import java.io.FileNotFoundException;

/**
* @projectName PAT_Java
* @package com.chen.mthread.n2
* @className com.chen.mthread.n2.Async

* @author chenyingtao
* @date 2025/4/20 14:38
* @version 1.0
* @description @todo 
*/
//@Slf4j(topic = "c.Sync")
public class Async {

    private static final String TARGET_FILE = "D:/Users/chenyingtao/Source/Repos/PAT_Java/MThread/HELP.md";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader.read(TARGET_FILE);
//        log.debug("main end ...");
        System.out.println("main end ...");
    }
}
