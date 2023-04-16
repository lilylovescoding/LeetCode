package package111_contest20230416;

public class Solution6375 {
    public int addMinimum(String word) {
        String s = "abc";
        int res = 0;
        int j = 0;

        for(int i = 0; i <word.length(); i++){
            while(word.charAt(i) != s.charAt(j)) {
                res += 1;
                j = (j + 1) % 3;
            }
            j = (j + 1) % 3;
        }

        if(j != 0) {
            res += 3 - j;
        }
        return res;
    }

    //晨晨的解法
//    public int addMinimum_cc(String word) {
//        int cnt = 0;
//        char[] chars = word.toCharArray();
//        int cur = 0;
//        for (int i = 0; i < chars.length; i++) {
//            int t = chars[i] - 'a';
//            if (t == cur) {
//                cur = (t + 1) % 3;
//                continue;
//            }
//            cnt += (t + 3 - cur) % 3;
//            cur = (t + 1) % 3;
//        }
//        return cnt + (3 - cur) % 3;
//    }


    public static void main(String[] args){
        String word = "aaaab";
        Solution6375 a = new Solution6375();
        int res = a.addMinimum(word);
        System.out.println(res);
    }

}
