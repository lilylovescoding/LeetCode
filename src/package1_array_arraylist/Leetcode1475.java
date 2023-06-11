package package1_array_arraylist;

public class Leetcode1475 {
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
}
