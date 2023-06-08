package package111_contest20230604;

public class Solution2 {
    public int semiOrderedPermutation(int[] nums) {
        int len = nums.length;

        if(nums[0] == 1 && nums[len - 1] == len) {
            return 0;
        }

        int res1 = 0;
        int res2 = 0;

        //需要去找1和6的位置，两种情况：1、n; n、1
        for(int i = 0; i < len; i++) {
            if(nums[i] == 1) {
                res1 = i;
            } else if(nums[i] == len) {
                res2 = i;
            }
        }
        if( res1 < res2) {
            return res1 + res2 - 1;
        } else {
            return res1 + res2;
        }
    }

    public static void main(String[] args) {
        Solution2 res = new Solution2();
        int[] nums = {2,1,4,3};
        int ans = res.semiOrderedPermutation(nums);
        System.out.println(ans);
    }
}
