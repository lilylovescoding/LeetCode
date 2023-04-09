package contest20230409;

import contest20230402.FindMatrix6363;

import java.util.List;

public class DiagonalPrime6361 {

    public int getMaxPrimeOnDiagonal(int[][] nums) {
        int maxPrime = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                maxPrime = Math.max(maxPrime, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                maxPrime = Math.max(maxPrime, nums[i][n - i - 1]);
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{5,17,7},{9,11,10}} ;

        DiagonalPrime6361 f = new DiagonalPrime6361();
        int res = f.getMaxPrimeOnDiagonal(nums);
        System.out.println(res);
    }
}
