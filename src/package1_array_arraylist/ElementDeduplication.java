package package1_array_arraylist;
import java.util.Arrays;

public class ElementDeduplication {

    //1.给定一个排好序的数组,消除里面的重复元素,对于重复元素只保留一个，返回去重后的长度
    public int[] removeDuplicates(int[] nums) {
        if(nums.length < 0) {
            return null;
        }

        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow - 1] == nums[fast]) {
                continue;
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return Arrays.copyOf(nums,slow);
    }

    //2.排好序的array, 重复元素最多保留2个，返回去重后的array和长度
    public int[] dedup(int[] nums) {

        if (nums.length >= 0 && nums.length < 2) {
            return nums;
        }
        if(nums.length < 0) {
            return null;
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
        return Arrays.copyOf(nums,slow);
    }


    public static void main(String[] args){
        int[] nums = {0,0,0,1,1,1,2,3,4};

        ElementDeduplication e = new ElementDeduplication();
        int[] res1 = e.removeDuplicates(nums);
        System.out.println(res1.length);    //[0, 1, 2, 3] 长度为4
        System.out.println(Arrays.toString(res1));

        //int[] nums2 = {0,0,0,1,1,1,2,3,4};

        //Arrays.sort(nums);
        ElementDeduplication d = new ElementDeduplication();
        int[] res2 = d.dedup(nums);
        System.out.println(res2.length);     //结果应为：[0，0，1，1，2，3] 长度为6
        System.out.println(Arrays.toString(res2));
        //System.out.println(Arrays.toString(res2));  //结果应为：[0，0，1，1，2，3]
    }
}
