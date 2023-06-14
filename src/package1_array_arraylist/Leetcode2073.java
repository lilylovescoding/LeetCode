package package1_array_arraylist;

//【买票需要的时间】：有n个人前来排队买票，其中第0人站在队伍最前方，第 (n-1) 人站在队伍最后方，给你一个下标从0开始的整数数组tickets，数组长度为n，其中第i人想要购买的票数为tickets[i]。
//每个人买票都需要用掉恰好1秒。一个人一次只能买一张票，如果需要购买更多票，他必须走到队尾重新排队（瞬间发生，不计时间）。如果一个人没有剩下需要买的票，那他将会离开队伍。返回位于位置k（下标从0开始）的人完成买票需要的时间（以秒为单位）
//tickets = [2,3,2], k = 2  =>  6
//tickets = [5,1,1,1], k = 0  =>  8
public class Leetcode2073 {

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
