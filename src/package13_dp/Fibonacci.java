package package13_dp;

public class Fibonacci {
    //Method1: Recursion <TC: O(2^n)   SC: O(n)>
    public int fibonacci1(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    //Method2: Recursion + Memoization <TC: O(n)   SC: O(n)>
    public int fibonacci2(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        Integer[] m = new Integer[n + 1];  //index永远比length少一
        if(m[n] != null) {
            return m[n];
        }
        m[n] = fibonacci2(n-1) + fibonacci2(n-2);
        return m[n];
    }

    //Method3: DP <TC: O(n)   SC: O(n)>
    public long fibonacci3(int n) {
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 0; i <= n; i++) {
            arr[n] = arr[n - 1] + arr[n - 2];
        }
        return arr[n];
    }

    //Method4: DP <TC: O(n)   SC: O(1)>
    public long fibonacci4(int n) {
        long a = 0;
        long b = 1;
        long res = 0;

        if(n == 0) {
            res = a;
        }
        if(n == 1) {
            res = b;
        }

        for(int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
