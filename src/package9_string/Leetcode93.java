package package9_string;
import java.util.List;

// 【复原 IP 地址】
// 有效IP地址正好由四个整数（每个整数位于0到255之间组成，且不能含有前导0），整数之间用 '.' 分隔
// 给定一个只包含数字的字符串 s ，用以表示一个IP地址，返回所有可能的有效IP地址，这些地址可以通过在s中插入'.' 来形成。你不能重新排序或删除s中的任何数字。你可以按任何顺序返回答案
// s = "25525511135"  =>  ["255.255.11.135","255.255.111.35"]
// s = "0000"  =>  ["0.0.0.0"]
// s = "101023"  =>  ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//public class Leetcode93 {
//    public List<String> restoreIpAddresses(String s) {
//        StringBuilder sb = new StringBuilder();
//        int len = s.length();
//        char[] arr = s.toCharArray();
//        char[] arr2 = new char[len+4];
//        for(int i = 0; i < len; i++) {
//            if(len <= 3) {
//                sb.append(arr[i]);
//                sb.append('.');
//            } else if () {
//
//            }
//        }
//
//    }
//}
