package package111_contest20230416;

import java.util.Arrays;

public class Solution6350 {

    public int maxDivScore(int[] nums, int[] divisors) {

        int maxdiv = 0;
        int num = divisors[0];

        for(int i = 0; i < divisors.length; i++) {
            int div = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] % divisors[i]== 0) {
                    div++;
                }
            }
            if(div > maxdiv) {
                maxdiv = div;
                num = divisors[i];
            } else if (div == maxdiv && divisors[i] < num) {
                num = divisors[i];
            }
        }
        return num;
    }

    //晨晨的解法
    public int maxDivScore_cc(int[] nums, int[] divisors) {
        int[] ans = new int[2];
        ans[0] = divisors[0];
        for (int i = 0; i < divisors.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    cnt++;
                }
            }
            if (cnt > ans[1]) {
                ans[0] = divisors[i];
                ans[1] = cnt;
            } else if (cnt == ans[1] && divisors[i] < ans[0]) {
                ans[0] = divisors[i];
            }
        }
        return ans[0];
    }

    public static void main(String[] args){
        int[] nums = {73,13,20,6};
        int[] divisors = {56,75,83,26,24,53,56,61};

        Solution6350 a = new Solution6350();
        int res = a.maxDivScore(nums, divisors);
        System.out.println(res);
    }
}

