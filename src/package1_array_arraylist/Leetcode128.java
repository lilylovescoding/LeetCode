package package1_array_arraylist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        //去重
        Set<Integer> ss = new HashSet<>();
        for(int num : nums) {
            ss.add(num);
        }
        System.out.println(ss);

        int[] arr = new int[ss.size()];
        int index = 0;
        for(Integer value : ss) {
            arr[index] = value;
            index++;
        }

        //排序
        Arrays.sort(arr);



        //DP查找最长连续
        int cur = 1;
        int res = 1;
        for(int i = 1; i < ss.size(); i++) {
            if(Math.abs(arr[i] - arr[i-1]) == 1){
                cur++;
                res = Math.max(cur, res);
            } else {
                cur = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode128 lee = new Leetcode128();
        int[] arr = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
        int res = lee.longestConsecutive(arr);
        System.out.println(res);
    }
}
