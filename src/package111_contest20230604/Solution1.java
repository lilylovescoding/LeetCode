package package111_contest20230604;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int minimizedStringLength(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        Solution1 res = new Solution1();
        String s = "abbaca";
        int ans = res.minimizedStringLength(s);
        System.out.println(ans);
    }

}
