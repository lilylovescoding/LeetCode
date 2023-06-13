package package1_array_arraylist;
import java.util.Arrays;

//无法吃午餐的学生数量
//给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），students[j]是初始队列里第j名学生对三明治的喜好（j=0是队列的最开始位置）,请返回无法吃午餐的学生数量
//students = [1,1,0,0], sandwiches = [0,1,0,1] => 0
//students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1] => 3
public class Leetcode1700 {
    //TC:(n) SC:(1)
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;

        for(int i = 0; i < sandwiches.length; i++) {
            if(s1 > 0 && sandwiches[i] == 1) {
                s1--;
            }else if(s0 > 0 && sandwiches[i] == 0) {
                s0--;
            }else{
                break;
            }
        }
        return s0 + s1;
    }
}
