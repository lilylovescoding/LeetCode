package package111_contest20230604;

public class Solution3 {
    public static long matrixSum(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        for (int[] query : queries) {
            int type = query[0];
            int index = query[1];
            int val = query[2];

            if (type == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[index][i] = val;
                }
            } else if (type == 1) {
                for (int i = 0; i < n; i++) {
                    matrix[i][index] = val;
                }
            }
        }
        long sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution3 res = new Solution3();
        int n = 3;
        int[][] queries = {{0,0,1},{1,2,2},{0,2,3},{1,0,4}};
        long ans = res.matrixSum(n, queries);
        System.out.println(ans);
    }

    //晨晨
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        boolean[][] vis = new boolean[2][n];
        int[] cnt = new int[2];
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            int type = query[0];
            int index = query[1];
            int val = query[2];
            if (vis[type][index]) {
                continue;
            }
            vis[type][index] = true;
            sum += (long) val * (n - cnt[1 - type]);
            cnt[type]++;
        }
        return sum;
    }
}
