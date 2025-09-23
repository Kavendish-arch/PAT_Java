package setDemo.demo1hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package setDemo.demo1hashset
 * @className setDemo.demo1hashset.Demo2
 * @date 2024/11/15 15:25
 * @description
 * 给定一个字符串 source 和一个待匹配的字符串 target，这两个字符串均只包含小写字母，并且不为空。
 * 需要在 source 中找到一个子字符串，该子字符串可以按序包含 target 的所有字符，但字符可以不连续。
 * 要求找出满足条件的最短子字符串，并返回其在 source 中的起止位置。
 * 若有多个结果，返回位置最小的那一个;若找不到符合要求的子串，则返回 -1 和 -1。
 *
 * 输入描述: 多行输入，每行包含一个 source 和一个 target，用空格分隔。
 * 保证1≤ |sourcel, ltarget|< 1000,且Σ|source|+ Σltarget| < 10000。
 *
 * 输出描述: 对每行输入，输出找到的最短子字符串的起始和结束位置(下标从 0 开始)。如果没有匹配子字符串，则返回 -1- 4。
 *
 * 示例输入:
 * abcdabxcdbabc
 * cba
 * abaxyzba
 * ba
 * abacbabcab
 * abc
 *
 * 示例输出: 10 126 7 7 9
 */
public class Demo2 {
    public static void main(String[] args) {

        String str = "abcdabxcdbabc";
        String target = "cba";



    }

    public static String findSubString(String source, String target)
    {
        Set<Character> targets = new HashSet<>();
        for(char c:target.toCharArray())
        {
            targets.add(c);
        }

        int start = 0;
        int end = source.length()-1;
        while (start<=end)
        {
            if(end - start < targets.size())
            {
                return "-1 -1";
            }
            else {
                String subStr = source.substring(start, end);
                boolean isFind = true;
                for(char c:targets)
                {
                    if(!subStr.contains(String.valueOf(c)))
                    {
                        isFind = false;
                        break;
                    }
                }
                if(isFind)
                {
                    return start+" "+end;
                }
                else {
                    start++;
                    end--;
                }
            }
            return start + " " + end;

        }
        return "";
    }
}
