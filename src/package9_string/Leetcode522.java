package package9_string;
// 【最长特殊序列】
// 给定字符串列表 strs ，返回其中最长的特殊序列的长度。如果最长特殊序列不存在，返回-1【s的子序列可以通过删去字符串s中的某些字符实现】
// [特殊序列]：该序列为某字符串独有的子序列（即不能是其他字符串的子序列）
// "abc"是 "aebdc"的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc"。"aebdc"的子序列还包括"aebdc"、 "aeb"和 ""(空字符串)
// strs = ["aba","cdc","eae"]  =>  3
// strs = ["aaa","aaa","aa"]  =>  -1
public class Leetcode522 {
    public int findLUSlength(String[] strs) {
        //Method1: 枚举每个字符串  TC:O(n^2 * i)  SC:O(1)
        int counts = strs.length;
        int res = -1;
        for(int i = 0; i < counts; i++) {
            boolean check = true;
            for(int j = 0 ; j < counts; j++) {
                if(i != j && isSubString(strs[i], strs[j])){
                    check = false;
                    break;
                }
            }
            if(check) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    public boolean isSubString(String a, String b) {
        int j = 0;
        int i = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public static void main(String[] args) {
        Leetcode522 lee = new Leetcode522();
        String[] strs = {"aaa","aaa","aa"};
        int res = lee.findLUSlength(strs);
        System.out.println(res);
    }
}
