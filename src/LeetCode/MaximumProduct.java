package LeetCode;

import java.util.Arrays;

/*
    No.628
    给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

    示例 1:

    输入: [1,2,3]
    输出: 6
    示例 2:

    输入: [1,2,3,4]
    输出: 24
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int index = nums.length;

        int a = nums[index - 1] * nums[index - 2] * nums[index - 3];
        int b = nums[0] * nums[1] * nums[index - 1];
        return a > b ? a : b;
    }
}
