package package12_dataConvert;
import java.util.*;
//【计数二进制子串】：给定一个字符串s，统计并返回具有相同数量0和1的非空(连续）子字符串的数量，并且这些子字符串中的所有0和所有1都是成组连续的 [重复出现（不同位置）的子串也要统计它们出现的次数]
//s = "00110011" => 6 ["0011"、"01"、"1100"、"10"、"0011" 和 "01" ]
//s = "10101" => 4 ["10"、"01"、"10"、"01"]
public class Leetcode696 {
    //Method1: TC:O(n)  SC:O(n)
    public int countBinarySubstrings1(String s) {
        List<Integer> counts = new ArrayList<>();
        int i = 0;
        int len = s.length();
        while(i < len){
            char ch = s.charAt(i);
            int count = 0;
            while(i < len && ch == s.charAt(i)) {
                i++;
                count++;
            }
            counts.add(count);
        }
        int ans = 0;
        for (i = 1; i < counts.size(); i++){
            ans += Math.min(counts.get(i), counts.get(i-1));
        }
        return ans;
    }

    //Method2: TC:O(n)  SC:O(1)
    public int countBinarySubstrings2(String s) {
        int i = 0, j=0, ans = 0;
        int len = s.length();
        while(i < len){
            int count = 0;
            char ch = s.charAt(i);
            while(i < len && s.charAt(i) == ch) {
                i++;
                count++;
            }
            ans += Math.min(count, j);
            j = count;
        }
        return ans;
    }
    public static void main(String[] args) {
        Leetcode696 lt= new Leetcode696();
        String a = "00110011";
        int res = lt.countBinarySubstrings1(a);
        System.out.println(res); //6
    }
}
