package package1_array_arraylist;
import java.util.*;

// [ 三数之和]
// 给你一个整数数组nums ，判断是否存在三元组[nums[i], nums[j], nums[k]] 满足i != j、i != k 且j != k ，同时还满足nums[i] + nums[j] + nums[k] == 0
// 请你返回所有和为0且不重复的三元组  [答案中不可以包含重复的三元组]
// nums = [-1,0,1,2,-1,-4]  =>  [[-1,-1,2],[-1,0,1]]
// nums = [0,1,1]  =>  []
// nums = [0,0,0]  =>  [[0,0,0]]
public class Leetcode15 {
    //TC:O(n^2)  SC:O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if(nums[0] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode15 lee = new Leetcode15();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = lee.threeSum(arr);
        System.out.println(res); // [[-1, -1, 2], [-1, 0, 1]]
    }
}
