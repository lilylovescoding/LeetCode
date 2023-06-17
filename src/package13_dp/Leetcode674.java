package package13_dp;

// [最长连续递增序列]
// 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
// nums = [1,3,5,4,7] => 3  [1,3,5]
// nums = [2,2,2,2,2] => 1
public class Leetcode674 {
    //Method: DP  TC:(n)  SC:O(1)
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int cur = 1;
        int res = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                cur++;
                res = Math.max(cur, res);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
