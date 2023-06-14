package package1_array_arraylist;
import java.util.HashMap;
import java.util.Map;

// 【多数元素】：给定一个大小为n的数组nums，返回其中的多数元素【指在数组中出现次数大于[n/2]的元素】
// nums = [3,2,3] => 3
// nums = [2,2,1,1,1,2,2] => 2
public class Leetcode169 {
    //TC:O(n)   SC:O(n)
    //思路：建一个HashMap，将nums中的值遍历一遍存进去，记录每个数出现的次数；再遍历HashMap，找到value > len/2的值，返回其key
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> hs = new HashMap<>();
        for(int num : nums) {
            if(!hs.containsKey(num)) {
                hs.put(num, 1);
            } else {
                hs.put(num, hs.get(num) + 1);
            }
        }
        //使用增强for循环来遍历HashMap hs中的键值对
        for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            if(entry.getValue() > len/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode169 lee = new Leetcode169();
        int[] nums = {2,2,1,1,1,2,2};
        int res = lee.majorityElement(nums);
        System.out.println(res);  //2
    }
}
