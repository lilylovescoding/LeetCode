package packagr111_contest20230430;

public class Solution1 {
    public int isWinner(int[] player1, int[] player2) {
        Solution1 s = new Solution1();
        int sum1 = s.sum(player1);
        int sum2 = s.sum(player2);

        if(sum1 == sum2) {
            return 0;
        } else if (sum1 > sum2) {
            return 1;
        } else {
            return 2;
        }
    }

    public int sum(int[] array) {
        int sum =0;

        for(int i = 0; i < array.length; i++) {
            if(i == 1 && array[0] == 10) {
                sum += 2 * array[i];
                continue;
            }

            if(i >= 2 && (array[i - 1] == 10 || array[i - 2] == 10)) {
                sum += 2 * array[i];
                continue;
            }
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] player1 = {5,6,1,10};
        int[] player2 = {5,1,10,5};
        int res = s.isWinner(player1, player2);
        System.out.println(res);
    }
}
