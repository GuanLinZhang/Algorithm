package LeetCode;

public class DuplicateNum {
    public int removeDuplicates(int[] nums) {

        int number = 0;//标记计数
        for (int i = 0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }

        }
        return number += 1;
    }
}


