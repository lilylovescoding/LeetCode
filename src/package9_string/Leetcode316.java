package package9_string;

import java.util.*;

//[去除重复字母]
// 给你一个字符串s，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）
// s = "bcabc" => "abc"
// s = "cbacdcbc" => "acdb"
public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

//    public String removeDuplicateLetters(String s) {
//        Map<Character, Integer> map = new TreeMap<>();
//        char[] arr = s.toCharArray();
//        System.out.println(arr);
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        System.out.println(map);
//
//        List<Character> list = new ArrayList<>();
//
//        int i = 0;
//        while (i < len && map.size() >= 1) {
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                while (i < len - 1 && map.containsKey(arr[i])) {
//                    i++;
//                }
//                list.add(arr[i]);
//                map.remove(arr[i]);
//                System.out.println(map);
//                break;
//            }
//            i++;
//        }
//        return String.valueOf(list);
//    }

    public static void main(String[] args) {
        Leetcode316 lee = new Leetcode316();
        String s = "cbacdcbc";
        String res = lee.removeDuplicateLetters(s);
        System.out.println(res);
    }
}
