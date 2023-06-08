package package111_contest20230604;

import java.util.Arrays;

public class Solution4 {

    //晨晨
    long mod = (long) (1e9 + 7);
    int n;
    int[] arr1;
    int[] arr2;
    long[][] dp;
    int min_sum;
    int max_sum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        n = num2.length();
        while (num1.length() < n) {
            num1 = "0" + num1;
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        arr1 = new int[n];
        arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = chars1[i] - '0';
            arr2[i] = chars2[i] - '0';
        }
        int s = n * 9 + 1;
        dp = new long[n + 1][s];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j >= k) {
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return (int) dfs(0, 0, 0);
    }

    private long dfs(int index, int t, int s) {
        if (index == n) {
            if (s >= min_sum && s <= max_sum) {
                return 1;
            } else {
                return 0;
            }
        }
        long cnt = 0;
        if (t == 0) {
            if (arr1[index] == arr2[index]) {
                cnt += dfs(index + 1, 0, s + arr1[index]);
            } else {
                cnt += dfs(index + 1, -1, s + arr1[index]);
                cnt += dfs(index + 1, 1, s + arr2[index]);
                for (int i = arr1[index] + 1; i < arr2[index]; i++) {
                    if (s + i > max_sum) {
                        break;
                    }
                    cnt += dp[n - 1 - index][Math.min(n * 9, max_sum - (s + i))];
                    if (min_sum - (s + i) > 0) {
                        cnt -= dp[n - 1 - index][Math.min(n * 9, min_sum - (s + i) - 1)];
                    }
                }
            }
        } else if (t == -1) {
            cnt += dfs(index + 1, -1, s + arr1[index]);
            for (int i = arr1[index] + 1; i < 10; i++) {
                if (s + i > max_sum) {
                    break;
                }
                cnt += dp[n - 1 - index][Math.min(n * 9, max_sum - (s + i))];
                if (min_sum - (s + i) > 0) {
                    cnt -= dp[n - 1 - index][Math.min(n * 9, min_sum - (s + i) - 1)];
                }
            }
        } else if (t == 1) {
            cnt += dfs(index + 1, 1, s + arr2[index]);
            for (int i = 0; i < arr2[index]; i++) {
                if (s + i > max_sum) {
                    break;
                }
                cnt += dp[n - 1 - index][Math.min(n * 9, max_sum - (s + i))];
                if (min_sum - (s + i) > 0) {
                    cnt -= dp[n - 1 - index][Math.min(n * 9, min_sum - (s + i) - 1)];
                }
            }
        }
        return (cnt + mod) % mod;
    }
}
