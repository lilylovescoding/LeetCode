package package1_array_arraylist;
import java.util.*;

public class Leetcode2363 {
    //TC:O((n+m)log(n+m)) SC:O(n+m) => [n, m分别为item1, item2的长度]
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> hs = new HashMap<>();  //创建hash表，空间n+m
        //将items1和items2转移到hash表中
        for(int[] v : items1) {
            hs.put(v[0], hs.getOrDefault(v[0], 0) + v[1]);
        }
        for(int[] v : items2) {
            hs.put(v[0], hs.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(k);
            pair.add(v);
            res.add(pair);
        }
        //对res进行排序，用Lambda表达式写排序规则，a.get(0)，b.get(0) = k
        Collections.sort(res, (a,b) -> a.get(0) - b.get(0));
        return res;
    }

    public static void main(String[] args) {
        Leetcode2363 lt= new Leetcode2363();
        int[][] items1 = {{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};
        List<List<Integer>> res = lt.mergeSimilarItems(items1, items2);
        System.out.println(res);
    }
}
