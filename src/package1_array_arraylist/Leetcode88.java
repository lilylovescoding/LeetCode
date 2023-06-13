package package1_array_arraylist;

//合并两个有序数组
//给两个非递减顺序的整数数组nums1和nums2，另有两个整数m和n分别表示nums1和nums2中的元素数目，合并nums2到nums1中，同样是非递减顺序
//nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3  => [1,2,2,3,5,6]
//nums1 = [1], m = 1, nums2 = [], n = 0  =>  [1]
public class Leetcode88 {
    //Method: TC:O(m+n)   SC:O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0;
        int j = 0;

        for (int x = 0; x < m+n; x++) {
            if(i < m && j < n && nums1[i] <= nums2[j]){
                res[x] = nums1[i];
                i++;
            }else if(i < m && j < n && nums1[i] > nums2[j]) {
                res[x] = nums2[j];
                j++;
            } else if (i < m) {
                res[x] = nums1[i];
                i++;
            } else if (j < n) {
                res[x] = nums2[j];
                j++;
            }
        }
        System.arraycopy(res, 0, nums1,0, res.length);
    }
}
