package package9_string;

//【字符串相加】：给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回
// num1 = "11", num2 = "123"  => "134"
// num1 = "456", num2 = "77"  => "533"
// num1 = "0", num2 = "0"  => "0"
public class Leetcode415 {
    //TC:O(max(len1,len2))  SC:O(1)
    public String addStrings(String num1, String num2) {
        StringBuilder  sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;

        while(i >= 0 || j >= 0 || add != 0) {
            int x = 0;
            int y = 0;

            if(i >= 0) {
                x = num1.charAt(i) - '0';
            } else {
                x = 0;
            }

            if(j >= 0) {
                y = num2.charAt(j) - '0';
            } else {
                y = 0;
            }

            int res = x + y + add;
            sb.append(res % 10);
            add = res/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode415 lt= new Leetcode415();
        String a = "11";
        String b = "123";
        String res = lt.addStrings(a, b);
        System.out.println(res); //134
    }
}
