package package1_array_arraylist;

import java.util.HashMap;
import java.util.Map;

//[下一个更大元素]
// 给定一个循环数组nums（nums[nums.length - 1] 的下一个元素是nums[0]），返回 nums 中每个元素的下一个更大元素
// nums = [1,2,1]  =>  [2,-1,2]
// [1,2,3,4,3]  => [2,3,4,-1,4]
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            int j = (i + 1) % len;
            while(i != j) {
                if(nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
                j = (j + 1) % len;
            }
            if(i == j) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode503 lee = new Leetcode503();
        int[] arr = {1,2,3,4,3};
        int[] res = lee.nextGreaterElements(arr);
        dayin(res);
    }

    public static void dayin(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]); //[2,3,4,-1,4]
        }
    }
}
