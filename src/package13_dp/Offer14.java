package package13_dp;
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
// 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？ [2 <= n <= 58]
// 2 => 1  [2 = 1 + 1, 1 × 1 = 1]
// 10 => 36  [10 = 3 + 3 + 4, 3 × 3 × 4 = 36]
public class Offer14 {
    //Method1: DP <TC:O(n^2) SC:O(n)>
    public int cuttingRope(int n) {
        int[] m = new int[n + 1];
        m[0] = 0;
        m[1] = 0;
        for(int i = 2; i <= n; i++) {
            int curMax = 0;
            for(int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j, m[j]) * (i - j));
            }
            m[i] = curMax;
        }
        return m[n];
    }

    //Method2: DFS <TC:O(n!) SC:O(n) on call stack>
    public int cuttingRope2(int n) {
        if( n <= 1) {
            return 0;
        }

        int maxProduct = 0;
        for(int i = 1; i < n; i++) {
            int best = Math.max(n-i, cuttingRope2(n-i));
            maxProduct = Math.max(maxProduct, best*i);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Offer14 lee = new Offer14();
        int n = 5;
        int res = lee.cuttingRope(n);
        System.out.println(res);
    }
}
