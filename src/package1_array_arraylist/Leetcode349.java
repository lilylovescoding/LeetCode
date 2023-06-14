package package1_array_arraylist;
import java.util.*;

//【两个数组的交集】
// 给定两个数组nums1和nums2，返回它们的交集。输出结果中的每个元素一定是唯一的。可以不考虑输出结果的顺序
// nums1 = [1,2,2,1], nums2 = [2,2]  => [2]
// nums1 = [4,9,5], nums2 = [9,4,9,8,4]  => [9, 4]
public class Leetcode349 {

    //TC:O(n)  SC:O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < len1; i++) {
            if(!seen.contains(nums1[i])){
                seen.add(nums1[i]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int j = 0; j < len2; j++) {
            if(seen.contains(nums2[j])){
                seen.remove(nums2[j]);
                res.add(nums2[j]);
            }
        }
        int[] ans = new int[res.size()];
        for(int k = 0; k < ans.length; k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode349 lee = new Leetcode349();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = lee.intersection(nums1, nums2);
        dayin(res);  // 2
        System.out.println(res); //[I@372f7a8d [2]
    }

    public static void dayin(int[] res) {
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
