package package9_string;

import java.util.HashSet;
import java.util.Set;

//【反转字符串中的元音字母】: 给一个字符串s，仅反转字符串中的所有元音字母，并返回结果字符串
// s = "leetcode" => "leotcede"    |   s = "hello" => "holle"
// TC:O(n) SC:O(n)
public class Leetcode345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            while(left < right && !vowels.contains(Character.toLowerCase(arr[left])) ){
                left++;
            }
            while(left < right && !vowels.contains(Character.toLowerCase(arr[right])) ){
                right--;
            }

            if(left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }

        }
        return new String(arr);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode345 a= new Leetcode345();
        String str = "Leetcode";
        String res = a.reverseVowels(str);
        System.out.println(res);   //Leotcede
    }
}
