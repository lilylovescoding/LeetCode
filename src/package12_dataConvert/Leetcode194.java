package package12_dataConvert;
//【转置文件】
// 给定一个文件 file.txt，转置它的内容
// 你可以假设每行列数相同，并且每个字段由 ' ' 分隔
// name age
// alice 21  =>  name alice ryan
// ryan 30       age   21    30
//public class Leetcode194 {
////
//////Read from the file file.txt and print its transposed content to stdout.
////    awk '{for(i=1; i<=NF; i++) {a[i]=a[i]" "$i;} } END {for(i=1; i<=NF; i++) {print a[i];} }' file.txt | sed 's/^ *//'
////
////}
