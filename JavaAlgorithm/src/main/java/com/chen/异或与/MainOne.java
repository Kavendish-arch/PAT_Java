package com.chen.异或与;//package 异或与;

import java.util.Scanner;

/**
 * 游游以前命名代码，习惯是这样的:
 * union find,in out,update user, update admin
 * 即变量中只使用小写字母以及下划线，两个单词用下划线相连
 * 但是小牛老师教会了他大驼峰法，即每个单词以大写字母开头，并且没有下划线相连，比如将上述的四个变量改成大驼峰法便是:
 * UnionFind,InOut. UpdateUser, UpdateAdmin
 * 所以游游现在的首要任务就是将他以前的代码中的变量命名全都改成大驼峰法，请你帮帮他吧。
 */
public class MainOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ncase = in.nextInt();
        in.nextLine(); // nextInt不会读取换行符，需要手动中止
        for (int i = 0; i < ncase; i++) {

            String str = in.nextLine();


            String result = solution(str);

            System.out.println(result);
        }
    }

    public static String solution(String str) {
        String[] allstr = str.split("_");
        StringBuffer res = new StringBuffer();
        for(String s:allstr)
        {
            StringBuffer tmp = new StringBuffer(s);
            char first = (char) (tmp.charAt(0) - 32);
            tmp.setCharAt(0, first);

            res.append(tmp);

        }
        return res.toString();
    }

}
