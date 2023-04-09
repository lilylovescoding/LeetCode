package contest20230409;

import java.util.*;

public class Distance6360 {

    //O(n^2)的时间复杂度
    public long[] getSum(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int len = list.size();
            if(len == 1) {
                continue;
            }
            long[] prefix = new long[len];
            prefix[0] = list.get(0);
            for(int i = 1; i < len; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for(int i = 0; i < len; i++){
                int idx = list.get(i);
                long leftSum = i == 0 ? 0L : prefix[i - 1], rightSum = prefix[len - 1] - prefix[i];
                arr[idx] = (2L * i + 1L - len) *idx + rightSum - leftSum;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,1,1,2};

        Distance6360 f = new Distance6360();
        long[] res = f.getSum(nums);
        System.out.println(res);
    }
}
