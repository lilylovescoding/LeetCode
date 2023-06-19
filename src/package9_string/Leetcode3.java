package package9_string;

import java.util.HashMap;
import java.util.Map;

//【无重复字符的最长子串】
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
// s = "abcabcbb" => 3
// s = "bbbbb" => 1
// s = "pwwkew" => 3
public class Leetcode3 {
    //滑动窗口：TC:O(n)  SC:O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode3 lee = new Leetcode3();
        String s = "abcabcbb";
        int res = lee.lengthOfLongestSubstring(s);
        System.out.println(res); //3
    }
}
