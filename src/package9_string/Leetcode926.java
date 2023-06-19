package package9_string;
// [将字符串翻转到单调递增]
// 如果一个二进制字符串，是以一些0（可能没有 0）后面跟着一些1（也可能没有1）的形式组成的，那么该字符串是单调递增的.
// 给你一个二进制字符串s，你可以将任何0翻转为1或者将1翻转为0, 返回使s单调递增的最小翻转次数
// s = "00110"  =>  1  [00111]
// s = "010110"  => 2  [011111 或 000111]
// s = "00011000" => 2  [00000000]
public class Leetcode926 {
    //动态规划：TC:O(n)  SC:O(1)
//    public int minFlipsMonoIncr(String s) {
//        int len = s.length();
//        int dp0 = 0;
//        int dp1 = 0;
//        for(int i = 0; i < len; i++) {
//            char c = s.charAt(i);
//            int dp0new = dp0;
//            int dp1new = Math.min(dp0, dp1);
//            if(c == '1'){
//                dp0new++;
//            } else {
//                dp1new++;
//            }
//            dp0 = dp0new;
//            dp1 = dp1new;
//        }
//        return Math.min(dp0, dp1);
//    }

    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] dp = new int[s.length()];
        int ans = 0;
        int num = s.charAt(0) == '0' ? 0 : 1;

        dp[0] = 0;
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) == '1') {
                dp[i] = dp[i - 1];
                num ++;
            } else {
                dp[i] = Math.min(num, dp[i - 1] + 1);
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        Leetcode926 lee = new Leetcode926();
        String s = "00110";
        int res = lee.minFlipsMonoIncr(s);
        System.out.println(res);
    }
}
