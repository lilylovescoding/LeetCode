package package1_array_arraylist;

import java.util.ArrayDeque;
import java.util.Deque;

//【商品折扣后的最终价格】：给一个数组prices，其中prices[i]是商店里第i件商品的价格，请返回一个数组，数组中第i个元素是折扣后你购买商品i最终需要支付的价格
// 商店里正在进行促销活动，如果你要买第i件商品，那么你可以得到与 prices[j] 相等的折扣，其中j是满足j > i且prices[j] <= prices[i]的最小下标，如果没有满足条件的j，你将没有任何折扣
// nums1 = [4,1,2], nums2 = [1,3,4,2] => [-1,3,-1]
// nums1 = [2,4], nums2 = [1,2,3,4] => [3,-1]
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
}
