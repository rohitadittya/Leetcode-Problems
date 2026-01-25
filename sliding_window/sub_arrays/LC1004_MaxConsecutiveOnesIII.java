package sliding_window.sub_arrays;

/*
    LC 1004: Max Consecutive Ones III | Medium
    https://leetcode.com/problems/max-consecutive-ones-iii/description/

    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

    Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
    
    Example 2:
    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class LC1004_MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, len = 0, ones = 0;

        for (; r < nums.length; r++) {
            if (nums[r] == 1) {
                ones++;
            }

            while ((r - l + 1) - ones > k && l <= r) {
                if (nums[l] == 1) {
                    ones--;
                }
                l++;
            }

            len = Math.max(len, r - l + 1);
        }

        return len;
    }
}
