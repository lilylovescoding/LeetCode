package package111_contest20230416;

import java.util.HashSet;
import java.util.Set;

//晨晨的解法
public class Solution6378 {
    int n;
    int[] cnt;
    Set<Integer>[] sets;
    int start;
    int end;
    int[] price;
    int[][] dp;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.n = n;
        this.price = price;
        cnt = new int[n];
        sets = new Set[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            sets[edge[0]].add(edge[1]);
            sets[edge[1]].add(edge[0]);
        }
        build(0, -1);
        for (int[] trip : trips) {
            start = trip[0];
            end = trip[1];
            dfs(0);
        }
        for (int i = 0; i < price.length; i++) {
            price[i] *= cnt[i];
        }
        dp = new int[n][2];
        dfs2(0);
        return Math.min(dp[0][0], dp[0][1]);
    }

    private void dfs2(int v) {
        int a = price[v] / 2;
        int b = price[v];
        for (Integer w : sets[v]) {
            dfs2(w);
            a += dp[w][1];
            b += Math.min(dp[w][1], dp[w][0]);
        }
        dp[v][0] = a;
        dp[v][1] = b;
    }

    private boolean[] dfs(int v) {
        boolean[] ans = new boolean[2];
        if (v == start) {
            ans[0] = true;
        }
        if (v == end) {
            ans[1] = true;
        }
        for (Integer w : sets[v]) {
            boolean[] arr = dfs(w);
            if (arr[0] && arr[1]) {
                return arr;
            }
            ans[0] |= arr[0];
            ans[1] |= arr[1];
        }
        if (ans[0] || ans[1]) {
            cnt[v]++;
        }
        return ans;
    }

    private void build(int v, int p) {
        sets[v].remove(p);
        for (Integer w : sets[v]) {
            build(w, v);
        }
    }
}