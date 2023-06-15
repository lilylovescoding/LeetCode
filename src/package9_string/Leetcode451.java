package package9_string;
import java.util.*;
//【根据字符出现频率排序】
// 给定一个字符串 s ，根据字符出现的频率对其进行降序排序 。一个字符出现的频率是它出现在字符串中的次数；返回已排序的字符串 。如果有多个答案，返回其中任何一个
// s = "tree"  =>  "eert"  |  s = "cccaaa"  =>  "cccaaa"  | s = "Aabb"  =>  "bbAa"
public class Leetcode451 {
    //Method1: TC:O(n+klogk)  SC:O(n+k) [n是字符串s的长度，k是字符串包含的不同字符的个数] [s只包括大写、小写字母和数字，s=26+26+10=62]
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();  //[e,e,r,t]
        for(char ar : arr) {
            map.put(ar, map.getOrDefault(ar, 0) + 1); //<e:2>, <r:1>, <t:1>
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int fre = map.get(c);
            for(int j = 0;j < fre; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //Method2: 桶排序  TC:O(n+k)  SC:O(n+k)
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
