package setDemo.demo1hashset;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package setDemo.demo1hashset
 * @className setDemo.demo1hashset.Demo3
 * @date 2024/11/15 15:21
 * @description 输入一个字符串(长度不超过80)，对字符串进行如下处理:如果字符是大写字符，则用该字符对应的小写字符替换，如果字符是小写字符，
 * 则用该字符对应的大写字符替换，其他字符则保持不变，输出经过处理的字符串。如输入:abKY12，则输出为:ABky12。
 */
public class Demo3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        args.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
            {
                ch += 32;
            }
            else if(ch >= 'a' && ch <= 'z'){
                ch -= 32;
            }
            sb.append(ch);
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
