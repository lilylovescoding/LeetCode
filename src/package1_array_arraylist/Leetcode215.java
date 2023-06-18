package package1_array_arraylist;

import java.security.Principal;
import java.util.*;

public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return 0;
        }

        int len = nums.length;

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i = 0;  i < k; i++) {
            minheap.add(nums[i]);
        }

        for(int j = k; j < nums.length; j++){

            int mid = minheap.peek();
            if(nums[j] > mid) {
                minheap.poll();
                minheap.add(nums[j]);
            }
        }
        return minheap.peek();
    }

    public static void main(String[] args) {
        Leetcode215 lee = new Leetcode215();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = lee.findKthLargest(nums, k);
        System.out.println(res); // 5
    }
}
