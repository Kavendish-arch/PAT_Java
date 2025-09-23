package com.demoTest;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.demoTest
 * @className com.demoTest.Solution3
 * @date 2024/11/17 22:02
 * @description ###
 * 题目3:  ```java 需求: 	打印出1到100之间的既是3的倍数又是5倍数的数字以及这些数字的和 实现步骤:	 ```
 * <p>
 * 题目4:  ```java 需求: 	从键盘上录入一个大于100的三位数,打印出100到该数字之间满足如下要求的数字,数字的个数,以及数字的和:
 * 1.数字的个位数不为7;
 * 2.数字的十位数不为5; 		3.数字的百位数不为3; 实现步骤:  ```
 * <p>
 * 题目5:  ```java 需求:
 * 1.打印所有四位数中 个位 + 千位 == 百位 + 十位 的数字
 * 2.最后要打印符合条件的数字的总数量
 * 3.打印格式如下: 		1010         1021          1032         1043          ....         以上满足条件的四位数总共有 615 个 实现步骤: 	      ```
 */
public class Solution3 {
    public static void solution3() {
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void solution4() {
//         * 题目4:  ```java 需求: 	从键盘上录入一个大于100的三位数,打印出100到该数字之间满足如下要求的数字,数字的个数,以及数字的和:
// * 1.数字的个位数不为7;
// * 2.数字的十位数不为5; 		3.数字的百位数不为3; 实现步骤:  ```
        int num = 483;
        for (int i = 100; i <= num; i++) {
            if (i % 10 != 7 && (i % 100 / 10) != 5 && i / 100 != 3) {
                System.out.println(i);
            }
        }
    }

    public static void solution5() {
        /**
         * * 1.打印所有四位数中 个位 + 千位 == 百位 + 十位 的数字
         * 2.最后要打印符合条件的数字的总数量
         * 3.打印格式如下: 		1010         1021          1032         1043          ....         以上满足条件的四位数总共有 615 个 实现步骤: 	      ```

         */
        int count = 0;
        for(int i = 1000; i <= 9999; i++){
            if((i % 10) + (i /1000) == (i % 100 / 10) + (i % 1000 /100)){
               count++;
            }
        }
        System.out.println(
                count
        );
    }

    public static void main(String[] args) {
//        solution3();
//        solution4();
        solution5();
    }
}
