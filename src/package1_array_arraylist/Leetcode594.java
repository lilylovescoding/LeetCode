package package1_array_arraylist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//【最长和谐子序列】：给你一个整数数组nums，请在所有可能的子序列中找到最长的和谐子序列的长度
// 【和谐数组】：是指一个数组里元素的最大值和最小值之间的差别正好是 1
// nums = [1,3,2,2,5,2,3,7]  =>  5  最长的和谐子序列是 [3,2,2,2,3]
// nums = [1,2,3,4]  =>  2
// nums = [1,1,1,1]  => 0
public class Leetcode594 {

    //Method1: 枚举【类似滑动窗口】  TC:O(nlogn)+O(2n)=O(nlogn)  SC:O(1)
    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for(int end = 0; end < nums.length; end++) {
            while(nums[end] - nums[begin] > 1) {
                begin++;
            }
            if(nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    //Method2：哈希表   TC:O(n)  SC:O(n)
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()) {
            if(map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode594 lee = new Leetcode594();
        int[] nums = {1,3,2,2,5,2,3,7};
        int res1 = lee.findLHS1(nums);
        int res2 = lee.findLHS2(nums);
        System.out.println(res1);  //5
        System.out.println(res2);  //5
    }
}
