package package9_string;

//【反转字符串】
//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
// s = ['h', 'e', 'l', 'l', 'o']  => ['o','l','l','e','h']
// s = ['H','a','n','n','a','h'] => ['h','a','n','n','a','H']
public class Leetcode344 {
    //TC:O(n) SC:O(1)
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i < j){
            Character temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Leetcode344 lee = new Leetcode344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        lee.reverseString(s);
        System.out.println(s); //olleh
    }
}
