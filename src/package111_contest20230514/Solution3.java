package package111_contest20230514;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int[] circularGameLosers(int n, int k) {
        //1.初始化人数
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        //2.设置一个boolean的数组，默认为false
        Boolean[] receive = new Boolean[n];
        for (int i = 0; i < n; i++) {
            receive[i] = false;
        }

        int res = 0;
        while(true) {
            
        }

    }
}