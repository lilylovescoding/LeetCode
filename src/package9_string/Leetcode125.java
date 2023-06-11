package package9_string;
public class Leetcode125 {
    //Method1: StringBuilder+翻转判断    TC:O(n) SC:O(n)
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();  //创建一个StringBuilder，用来装string
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {   //遍历string，如果是字符或数字就加到sb中
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb).reverse(); //新建sb2，存翻转后的sb
        return sb.toString().equals(sb2.toString());
    }

    //Method2: StringBuilder+双指针  TC:O(n) SC:O(n)
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;  int right = sb.length() - 1;
        while(left < right) {
            if(Character.toLowerCase(sb.charAt(left)) != Character.toLowerCase(sb.charAt(right))) {
                return false;}
            left++;
            right--;
        }
        return true;
    }

    //Method3:直接判断  TC:O(n) SC:O(1)
    public boolean isPalindrome3(String s) {
        int left = 0;  int right = s.length() - 1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;}
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;}
            if(left < right) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;}
                left++;
                right--;
            }
        }
        return true;
    }
}
