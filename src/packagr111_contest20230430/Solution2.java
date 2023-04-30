package packagr111_contest20230430;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[] {i,j});
            }
        }

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0; i < arr.length; i++) {
            int[] cur = map.get(arr[i]);
            int r = cur[0];
            int c = cur[1];

            if(row[r] == 0 ) {
                row[r] = 1;
            } else {
                row[r]++;
            }

            if(row[r] == n) {
                return i;
            }

            if(col[c] == 0) {
                col[c] = 1;
            } else {
                col[c]++;
            }

            if(col[c] == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5}, {1,4,6}};

        int res = s.firstCompleteIndex(arr, mat);
        System.out.println(res);
    }
}
