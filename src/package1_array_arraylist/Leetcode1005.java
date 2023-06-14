package package1_array_arraylist;
import java.util.Arrays;

//【K 次取反后最大化的数组和】
// 给你一个整数数组nums和一个整数k，按以下方法修改该数组：选择某个下标i并将nums[i]替换为 -nums[i] 。重复这个过程恰好k次。可以多次选择同一个下标i。以这种方式修改数组后，返回数组可能的最大和
// nums = [4,2,3], k = 1  => 5     选择下标 1 ，nums 变为 [4,-2,3]
// nums = [3,-1,0,2], k = 3  => 6    选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2]
// nums = [2,-3,-1,5,-4], k = 2  => 13   选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4]
public class Leetcode1005 {
    //TC:O(n) SC:O(1)
    public int largestSumAfterKNegations(int[] nums, int k) {
        //从小到大排序：将所有的负数排到前面
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            //如果nums[i]为负数，且k>0，则将其变为正数
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            res += nums[i];
        }
        //从小到大排序
        Arrays.sort(nums);
        //如果k是偶数或0，则直接返回res【对同一数字正负正负】
        if(k % 2 == 0) {
            return res;
        //如果k是奇数，则返回res-2倍的nums[0]【减一份和多加的一份】
        } else {
            return res - 2*nums[0];
        }
    }

    public static void main(String[] args) {
        Leetcode1005 lee = new Leetcode1005();
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        int res = lee.largestSumAfterKNegations(nums, k);
        System.out.println(res);  //13
    }
}
