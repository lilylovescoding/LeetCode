package package1_array_arraylist;

import java.util.HashSet;

// [反转之后不同整数的数目]
// 给你一个由正整数组成的数组 nums,必须取出数组中的每个整数，反转其中每个数位，并将反转后得到的数字添加到数组的末尾。这一操作只针对nums中原有的整数执行.返回结果数组中不同整数的数目
// nums = [1,13,10,12,31] => 6
// nums = [2,2,2] => 1
public class Leetcode2442 {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        for(int num : nums) {
            ans.add(num);
            int sum = 0;
            while( num != 0) {
                sum = sum * 10 + num % 10;
                num /= 10;
            }
            if(sum != num) {
                ans.add(sum);
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        Leetcode2442 lee = new Leetcode2442();
        int[] arr = {123,13,112,12,31};
        int res = lee.countDistinctIntegers(arr);
        System.out.println(res); //8
    }
}
