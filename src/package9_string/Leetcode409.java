package package9_string;

import java.util.*;

//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串。"abccccdd"：7 "dccaccd"
//TC:O(n)  SC:O(n)
public class Leetcode409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> hs = new HashMap<>();  //创建HashMap

        for(int i = 0; i < s.length(); i++){     //在HashMap中存放string的char和出现的次数
            hs.merge(s.charAt(i), 1, (a,b) -> a + b);
        }

        int res = 0;
        int odd = 0;
        for(Map.Entry<Character, Integer> kv : hs.entrySet()) {
            int count = kv.getValue();
            int rem = count % 2;
            res += count - rem;
            if(rem == 1) {
                odd = 1;
            }
        }
        return res + odd;
    }

    public static void main(String[] args) {
        Leetcode409 lt= new Leetcode409();
        String a = "aaaaaccc";
        int res = lt.longestPalindrome(a);  //7
        System.out.println(res);
    }
}
