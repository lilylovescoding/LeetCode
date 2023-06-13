package package1_array_arraylist;

public class Leetcode2073 {
    //买票需要的时间
    //tickets = [2,3,2], k = 2  =>  6
    //tickets = [5,1,1,1], k = 0  =>  8
    //TC:(n) SC:(1)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;
        int res = 0;
        for(int i = 0; i <= len; i++){
            if( i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res;
    }
}
