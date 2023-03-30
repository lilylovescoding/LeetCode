package array_arraylist;

public class ElementDeduplication {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow - 1] == nums[fast]) {
                continue;
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args){
        int[] nums = {0,0,0,1,1,2,3};

        ElementDeduplication redup = new ElementDeduplication();
        int res = redup.removeDuplicates(nums);
        System.out.println(res);

    }
}
