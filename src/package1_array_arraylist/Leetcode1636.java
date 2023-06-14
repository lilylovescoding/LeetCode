package package1_array_arraylist;

import java.util.*;

//【按照频率将数组升序排序】：给一个整数数组nums，请将数组按照每个值的频率升序排序。如果有多个值的频率相同，请你按照数值本身将它们降序排序.返回排序后的数组
// nums = [1,1,2,2,2,3]  =>  [3,1,1,2,2,2]
// nums = [2,3,1,3,2]  =>  [1,3,3,2,2]
// nums = [-1,1,-6,4,5,-6,1,4,1]  =>  [5,-1,4,4,-6,-6,1,1,1]
public class Leetcode1636 {
    //TC:O(nlogn) SC:O(n)  【排序消耗O(nlogn)的时间】
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        //使用Collections.sort()方法对list集合进行排序，排序规则由(a,b)->{Lambda表达式}决定
        //(a,b)->{...}定义了一个比较器，用于比较集合中的元素，通过map.get(a)和map.get(b)分别获取a和b在map中的值
            //若map1 != map2，则返回[map1-map2]的差值，按照差值升序排序；若map1 == map2，则返回[b-a]的差值，按照差值降序排序；
        Collections.sort(list, (a,b) -> {
            int map1 = map.get(a);
            int map2 = map.get(b);
            return map1 != map2 ? map1 - map2 : b - a;
        });

        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
