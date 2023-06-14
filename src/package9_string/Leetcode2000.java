package package9_string;
//【反转单词前缀】
// 给你一个下标从0开始的字符串word和一个字符ch。找出ch第一次出现的下标i，反转word中从下标0开始、直到下标i结束（含下标i）的那段字符。如果word中不存在字符ch，则无需进行任何操作，返回结果字符串
// word = "abcdefd", ch = "d" => "dcbaefd"  ["d"第一次出现在下标3。反转从下标0到下标3（含下标3）的这段字符，结果字符串是 "dcbaefd"]
// word = "xyxzxe", ch = "z"  => "zxyxxe"
// word = "abcd", ch = "z"  => "abcd"
public class Leetcode2000 {

    //TC:O(n)  SC:O(n)
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int i = 0;
        int j = 0;
        int k = 0;
        while(j < arr.length) {
            if (arr[j] != ch) {
                j++;
            } else {
                k = j;
                break;
            }
        }
        while(i < k) {
            swap(arr, i, k);
            i++;
            k--;
        }
        //这里将char[]数组转换为字符串，不能用arr.toString() => 会返回一个地址
        //可使用String类的构造函数或静态方法valueOf()
        return String.valueOf(arr);
    }

    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode2000 lee = new Leetcode2000();
        String word = "abcdefg";
        char ch = 'd';
        String res = lee.reversePrefix(word, ch);
        System.out.println(res);  //dcbaefg
    }
}
