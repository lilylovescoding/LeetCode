package contest20230402;

import java.util.*;

public class FindMatrix6363 {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<Set<Integer>> sets = new ArrayList<>();
        cc:
        for (int num : nums) {
            for (Set<Integer> set : sets) {
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                continue cc;
            }
            Set<Integer> set = new HashSet<>();
            set.add(num);
            sets.add(set);
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (Set<Integer> set : sets) {
            lists.add(new ArrayList<>(set));
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,4};

        FindMatrix6363 f = new FindMatrix6363();
        List<List<Integer>> ans = f.findMatrix(nums);
        System.out.println(ans);
    }
}
