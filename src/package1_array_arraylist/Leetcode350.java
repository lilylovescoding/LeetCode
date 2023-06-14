package package1_array_arraylist;

import java.util.ArrayList;
import java.util.TreeMap;

//【两个数组的交集】
// 给两个整数数组nums1和nums2，请以数组形式返回两数组的交集
// 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可不考虑输出结果的顺序
public class Leetcode350 {
    //TC:O(n)  SC:O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int num : nums1) {
            if(!tm.containsKey(num)){
                tm.put(num, 1);
            } else {
                tm.put(num, tm.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(tm.containsKey(num)) {
                list.add(num);
                tm.put(num, tm.get(num) - 1);
                if(tm.get(num) == 0) {
                    tm.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode350 lee = new Leetcode350();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = lee.intersect(nums1, nums2);
        dayin(res);  // 2,2
        System.out.println(res); //[I@372f7a8d [2,2]
    }

    public static void dayin(int[] res) {
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
