package package1_array_arraylist;
import java.util.Arrays;
// [最小绝对差值和]
// 给你两个正整数数组nums1和nums2，数组的长度都是n. 数组nums1和nums2的绝对差值和定义为所有 |nums1[i]-nums2[i]|（0<=i<n的总和（下标从0开始）
// 你可以选用nums1中的任意一个元素来替换nums1中的至多一个元素，以最小化绝对差值和
// 在替换数组nums1中最多一个元素之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余后返回
// nums1 = [1,7,5], nums2 = [2,3,5]  =>  3  [将第二个元素替换为第一个元素：[1,7,5] => [1,1,5]] 或 [将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]]
// nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]  => 0  [nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0]
// nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]  =>  20  [将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7] 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
public class Leetcode1818 {
    //排序+二分查找：TC:O(nlogn)  SC:O(n)
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if( j < n) {
                maxn = Math.max(maxn, diff -(rec[j] - nums2[i]));
            }
            if(j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if(arr[right] < target) {
            return right + 1;
        }

        while(left < right) {
            int mid = left + (right - left)/2;
            if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode1818 lee = new Leetcode1818();
        int[] a = {1,10,4,4,2,7};
        int[] b = {9,3,5,1,7,4};
        System.out.println(lee.minAbsoluteSumDiff(a,b));  //20
    }
}
