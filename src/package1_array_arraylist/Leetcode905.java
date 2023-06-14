package package1_array_arraylist;
//【按奇偶排序数组】：给你一个整数数组nums，将nums中的的所有偶数元素移动到数组的前面，后跟所有奇数元素
// nums = [3,1,2,4]  =>  [2,4,3,1]
// nums = [0]  =>  0
public class Leetcode905 {
    //Method1: 双指针  TC:O(n)  SC:O(n)
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = i + 1;

        while(j < nums.length) {
            if(nums[i] % 2 == 0) {
                i++;
            }
            if(nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                i++;
            }
            j++;
        }
        return nums;
    }

    //Method2：两次遍历  TC:O(n)  SC:O(n)
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int index = 0;
        int[] res = new int[n];

        for(int num : nums) {
            if(num % 2 == 0){
                res[index++] = num;
            }
        }

        for(int num : nums) {
            if(num % 2 != 0) {
                res[index++] = num;
            }
        }
        return res;
    }

    //Method3: 双指针+一次遍历  TC:O(n)  SC:O(n)
    public int[] sortArrayByParity3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        for(int num : nums) {
            if(num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }
}
