package package12_dataConvert;
//【数字的补数】
// 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。给你一个整数 num ，输出它的补数
// num = 5 => 2 [整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 ]
// num = 1 => 1 [1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0]
public class Leetcode476 {
    //TC：O(n)  SC:(1)
    public int findComplement(int num) {
        //十进制转二进制
        String binary = Integer.toBinaryString(num);
        //二进制取反
        char[] ch = binary.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            ch[i] = ch[i] == '1' ? '0' : '1';
        }
        //二进制转十进制
        String binary2 = String.valueOf(ch);
        return Integer.parseInt(binary2, 2);
    }
}
