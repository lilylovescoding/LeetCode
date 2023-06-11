package package1_array_arraylist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for(int j = i + 1; j < nums2.length; j++) {
                if(nums2[j] > nums2[i]) {
                    hs.put(nums2[i], nums2[j]);
                    break;
                } else {
                    hs.put(nums2[i], -1);
                }
            }
        }
        hs.put(nums2[nums2.length -1], -1);



        int[] arr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            arr[i] = hs.get(nums1[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Leetcode496 lt= new Leetcode496();
        int[] items1 = {4,1,2,5,3};
        int[] items2 = {5,6,1,3,4,2};
        int[] res = lt.nextGreaterElement(items1, items2);
        dayin(res);
//        System.out.println(res);
    }

    public static void dayin(int[] res){
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
