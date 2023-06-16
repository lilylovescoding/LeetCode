package package9_string;
import java.util.*;
// [反转每对括号间的子串]
// 给出一个字符串s（仅含有小写英文字母和括号）,请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果 [结果中不应包含任何括号]
// s = "(abcd)" => "dcba"
// s = "(u(love)i)"  => "iloveu"
// s = "(ed(et(oc))el)"  => "leetcode"
// s = "a(bcdefghijkl(mno)p)q"  => "apmnolkjihgfedcbq"
public class Leetcode1190 {
    //Method1：栈：TC:O(n^2)  SC:(n)
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if(ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    //Method2：预处理括号：TC:O(n)  SC:(n)
    public String reverseParentheses2(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
