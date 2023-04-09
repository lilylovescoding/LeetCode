package contest20230409;

import java.util.Arrays;

public class MinimizeMax6359 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1];
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] <= mid) {
                    cnt++;
                    i++;
                }
            }
            if (cnt >= p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
