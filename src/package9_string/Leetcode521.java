package package9_string;

//给两个字符串 a 和 b，请返回这两个字符串中最长的特殊序列的长度。如果不存在，则返回-1 [最长特殊序列: 该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）]
//a = "aba", b = "cdc" => 3 [最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列]
//a = "aaa", b = "bbb" => 3 [最长特殊序列是 "aaa" 和 "bbb"]
//a = "aaa", b = "aaa" => -1 [字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。]
public class Leetcode521 {
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
