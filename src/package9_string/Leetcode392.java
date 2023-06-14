package package9_string;

//【判断子序列】：给定字符串 s 和 t ，判断 s 是否为 t 的子序列
//s = "abc", t = "ahbgdc"  =>  true
//s = "axc", t = "ahbgdc"  =>  false
public class Leetcode392 {

    //双指针  TC:(m+n) OC(1)
    public boolean isSubsequence(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();

        int i = 0;
        int j = 0;
        while(i < len1 && j < len2) {
            if(s.charAt(i) == s.charAt(j)){
                i++;
            }
            j++;

        }
        return i == len1;
    }

    public static void main(String[] args) {
        Leetcode392 lt= new Leetcode392();
        String a = "abc";
        String b = "ahbgdc";
        Boolean res = lt.isSubsequence(a,b);
        System.out.println(res); //true
    }
}
