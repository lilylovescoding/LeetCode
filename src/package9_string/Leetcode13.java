package package9_string;

import java.util.HashMap;
import java.util.Map;

//"III" => 3
public class Leetcode13 {
    Map<Character, Integer> values = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            int temp = values.get(s.charAt(i));
            if(i < len-1 && temp < values.get(s.charAt(i+1))) {     //这里注意是i < len-1
                res -= temp;
            } else {
                res += temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode13 a = new Leetcode13();
        int ans = a.romanToInt("III");
        System.out.println(ans);
    }
}
