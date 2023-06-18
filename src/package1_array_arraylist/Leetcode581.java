package package1_array_arraylist;
import java.util.Arrays;
public class Leetcode581 {
    //排序：TC:O(nlogn)  SC:O(n)
    public int findUnsortedSubarray(int[] nums) {
        if(isSorted(nums)) {
            return 0;
        }
        int[] newArr = new int[nums.length];
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(newArr[left] == nums[left]) {
           left++;
        }
        while(newArr[right] == nums[right]) {
           right--;
        }
        return right - left + 1;

    }
    public boolean isSorted(int[] arr) {
        if(arr.length == 0) {
            return true;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }


    //一次遍历：TC:O(n)  SC:O(1)
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int maxVal = Integer.MIN_VALUE;
        int left = -1;
        int minVal = Integer.MAX_VALUE;
        int right = -1;

        for(int i = 0; i < len; i++) {
            if(maxVal > nums[i]) {
                right = i;
            } else {
                maxVal = nums[i];
            }

            if(minVal < nums[len - i - 1]) {
                left = len - i - 1;
            } else {
                minVal = nums[len - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
