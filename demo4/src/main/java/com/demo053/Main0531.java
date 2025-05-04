package com.demo053;

public class Main0531 {

    int num = 0;
    boolean ready = false;

    public void actor(I_Result r) {
        if (ready) {
            r.r1 = num + num;
        } else {
            r.r1 = num;
        }
    }

    public void actor2(I_Result r) {
        num = 2;
        ready = true;
    }
}

class I_Result {
    public int r1;
}