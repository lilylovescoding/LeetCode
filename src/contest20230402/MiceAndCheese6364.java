package contest20230402;

import java.util.Arrays;
import java.util.List;

public class MiceAndCheese6364 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = Arrays.stream(reward2).sum();
        int n = reward1.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            sum += arr[n - i - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,3,4};
        int[] nums2 = {4,4,1,1};
        int k = 2;

        MiceAndCheese6364 f = new MiceAndCheese6364();
        int ans = f.miceAndCheese(nums1, nums2, k);
        System.out.println(ans);
    }
}
