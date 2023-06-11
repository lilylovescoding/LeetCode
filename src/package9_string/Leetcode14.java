package package9_string;

//查找字符串数组中的最长公共前缀. "flower", "flow", "flight" => "fl"
public class Leetcode14 {
    //Method1: 横向扫描  TC:O(mn) SC:O(1)
    public String longestCommonPrefix1(String[] str) {
        if(str == null || str.length == 0){
            return "";
        }
        String prefix = str[0];
        int count = str.length;
        for(int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, str[i]);
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    //Method2: 纵向扫描   TC:O(mn) SC:O(1)
    public String longestCommonPrefix2(String[] str){
        if(str == null || str.length == 0){
            return "";
        }
        int length = str[0].length();
        int count = str.length;

        for(int i = 0; i < length; i++) {
            char c = str[0].charAt(i);
            for(int j = 1; j < count; j++) {
                if(i == str[j].length() || str[j].charAt(i) != c) {
                    return str[0].substring(0,i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args) {
        Leetcode14 a = new Leetcode14();
        String[] str = {"flower", "flow", "flight"};
        String res1 = a.longestCommonPrefix1(str);
        String res2 = a.longestCommonPrefix2(str);
        System.out.println(res1);
        System.out.println(res2);
    }
}