package array_arraylist;

import java.util.Arrays;

public class ElementDeduplication {

    //给定一个排好序的数组,消除里面的重复元素,对于重复元素只保留一个，返回去重后的长度
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow - 1] == nums[fast]) {
                continue;
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //排好序的array, 重复元素最多保留2个，返回去重后的array和长度
    public int[] dedup(int[] nums) {

        if (nums.length <= 2) {
            return nums;
        }

        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[slow - 2] == nums[fast]) {
                continue;
            } else {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return Arrays.copyOf(nums, slow);
    }



    public static void main(String[] args){
        int[] nums1 = {0,0,0,1,1,2,3};
        ElementDeduplication e = new ElementDeduplication();
        int res1 = e.removeDuplicates(nums1);
        System.out.println(res1);


        //这里貌似打印array数组的值需要另外一种写法
        ElementDeduplication d = new ElementDeduplication();
        int[] res2 = d.dedup(nums1);
        System.out.println(res2.length);
    }
}
