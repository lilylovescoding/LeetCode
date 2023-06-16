package package1_array_arraylist;
import java.util.*;

//【下一个更大元素】：给两个没有重复元素的数组nums1和nums2,返回下一个更大元素I
// nums1中数字x的下一个更大元素是指x在nums2中对应位置右侧的第一个比x大的元素
//nums1 = [4,1,2], nums2 = [1,3,4,2] => [-1,3,-1]

public class Leetcode496 {
    //Method1：双层遍历+哈希表：TC:O(n^2 + m) SC:O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for(int j = i + 1; j < nums2.length; j++) {
                if(nums2[j] > nums2[i]) {
                    hs.put(nums2[i], nums2[j]);
                    break;
                } else {
                    hs.put(nums2[i], -1);
                }
            }
        }
        hs.put(nums2[nums2.length -1], -1);
        int[] arr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            arr[i] = hs.get(nums1[i]);
        }
        return arr;
    }

    //Method2：单调栈+哈希表：TC:O(n+m) SC:O(n)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hs = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            hs.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            res[i] = hs.get(nums1[i]);
        }
        return res;
    }
}
