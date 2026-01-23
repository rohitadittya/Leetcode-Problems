package sliding_window.sub_arrays;

/*
    LC 209. Minimum Size Subarray Sum | Medium
    https://leetcode.com/problems/minimum-size-subarray-sum/description/?source=submission-noac

    Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead. 

    Example 1:
    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.
    
    Example 2:
    Input: target = 4, nums = [1,4,4]
    Output: 1

    Example 3:
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0
*/
public class LC209_MinSizeSubArrSum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, st = 0, end = 0, minLen = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum = nums[end] + sum;
            if (sum >= target) {
                while (sum >= target && st <= end) {
                    minLen = Math.min(minLen, end - st + 1);
                    sum -= nums[st];
                    st++;
                }
            }

            end++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}
