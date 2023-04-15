package package111_contest20230402;

public class FindTheLongestBalancedSubstring6362 {
    public int findBalance (String s) {
        int count0 = 0, count1 = 0;
        boolean seen0 = false;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(i == 0 || s.charAt(i - 1) == '1') {
                    seen0 = true;
                    count0 = 0;
                } else {
                    count0++;
                }
            } else {
                if(i == 0 || (i > 0 && s.charAt(i - 1) == '0')) count1 = 0;
                    count1 ++;
                if(seen0) {
                    res = Math.max(res, Math.min(count0, count1) * 2);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "01000111";

        FindTheLongestBalancedSubstring6362 f = new FindTheLongestBalancedSubstring6362();
        int ans = f.findBalance(s);
        System.out.println(ans);
    }

}
