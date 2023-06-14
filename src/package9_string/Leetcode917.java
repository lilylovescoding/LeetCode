package package9_string;
// 【仅仅反转字母】
//给你一个字符串 s ，根据下述规则反转字符串：所有非英文字母保留在原有位置；所有英文字母（小写或大写）位置反转。返回反转后的s
// s = "ab-cd"  =>  "dc-ba"
// s = "a-bC-dEf-ghIj"  =>  "j-Ih-gfE-dCba"
// s = "Test1ng-Leet=code-Q!"  =>  "Qedo1ct-eeLg=ntse-T!"
public class Leetcode917 {
    //TC：O(n)  SC:O(n)
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();

        while(i < j) {
            //i < j：防止进入死循环【即string中没有字母】
            while(i < j && !Character.isLetter(s.charAt(i))){
                i++;
            }
            while(j > i && !Character.isLetter(s.charAt(j))) {
                j--;
            }
            swap(ch, i ,j);
            i++;
            j--;
        }
        return String.valueOf(ch);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode917 lee = new Leetcode917();
        String s = "Test1ng-Leet=code-Q!";
        String res = lee.reverseOnlyLetters(s);
        System.out.println(res);
    }
}
