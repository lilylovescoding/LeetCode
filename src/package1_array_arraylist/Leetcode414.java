package package1_array_arraylist;

import java.util.TreeSet;

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数
//[3, 2, 1] => 1 | [1, 2] => 2 | [2, 2, 3, 1] => 1
public class Leetcode414 {
    //Method: 有序集合TC:O(n)   SC:O(1)
    public int thirdMax(int[] nums) {
        //TreeSet是Java中的一个基于红黑树实现的有序集合类
        TreeSet<Integer> s = new TreeSet<>();
        for(int num : nums) {
            s.add(num);
            if(s.size() > 3) {
                //s.first()是集合中第一个（最小的）元素
                s.remove(s.first());
            }
        }
        //s.last()是集合中最后一个（最大的）元素
        return s.size() == 3 ? s.first() : s.last();
    }
}
