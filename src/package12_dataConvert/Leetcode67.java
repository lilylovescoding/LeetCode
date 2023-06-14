package package12_dataConvert;
//【二进制求和】：两个二进制字符串a和b，以二进制字符串的形式返回它们的和
//a = "1010", b = "1011" => "10101"
//a = "11", b = "1"  => "100"
public class Leetcode67 {
    //Method1: 将a和b转为十进制数，求和后再转为二进制【Python和Java自带高精度运算,其他语言不适用】
    //在Java中，字符串超过33位，不能转为Integer；超过65位，不能转为Long；超过500000001位，不能转为BigInteger
    //TC:O(m+n)  SC:O(1)
    public String addBinary1(String a, String b){
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    //Method2：模拟【末尾对齐，逐位相加，逢二进一】
    // TC:O(n)  SC:O(1)
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int res = 0;

        while (i >= 0 && j >= 0) {
            int sum = res;
            sum += (a.charAt(i) - '0') + (b.charAt(j) - '0');
            res = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }

        while(i >= 0) {
            int sum = res + (a.charAt(i) - '0');
            res = sum/2;
            sb.append(sum % 2);
            i--;
        }
        while(j >= 0) {
            int sum = res+ (b.charAt(j) - '0');
            res = sum/2;
            sb.append(sum % 2);
            j--;
        }
        if( res == 1) {
            sb.append(res);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode67 ll = new Leetcode67();
        String a = "1";
        String b = "111";
        String res = ll.addBinary2(a, b);
        System.out.println(res);
    }
}
