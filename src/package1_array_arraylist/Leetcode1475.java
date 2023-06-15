package package1_array_arraylist;

import java.util.ArrayDeque;
import java.util.Deque;

//【商品折扣后的最终价格】：给一个数组prices，其中prices[i]是商店里第i件商品的价格，请返回一个数组，数组中第i个元素是折扣后你购买商品i最终需要支付的价格
// 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣
// prices = [8,4,6,2,3]  =>  [4,2,4,2,3]
// prices = [1,2,3,4,5]  =>  [1,2,3,4,5]
// prices = [10,1,1,6]   =>  [9,0,1,6]
public class Leetcode1475 {
    //直接遍历：TC:O(n^2) SC:O(n)
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            int j = i + 1;
            while (j < len && prices[j] > prices[i]) {
                j++;
            }
            arr[i] = j < len ? prices[i] - prices[j] : prices[i];
        }
        return arr;
    }

    //单调栈：TC:O(n) SC:O(n)
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode1475 lee = new Leetcode1475();
        int[] arr = {8,4,6,2,3};
        int[] res1 = lee.finalPrices(arr); // [4,2,4,2,3]
        dayin(res1);  // 42423
        int[] res2 = lee.finalPrices2(arr); // [4,2,4,2,3]
        dayin(res2);  // 42423
    }

    public static void dayin(int[] res){
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
        }
        System.out.println();
    }
}
