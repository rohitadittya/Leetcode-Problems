package prefix_sum.Arrays;

import java.util.HashMap;

/*
    Day 2 | Problem 5
    LC 560. Subarray Sum Equals K | Medium
    https://leetcode.com/problems/subarray-sum-equals-k/

    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2
 */
public class LC560_SubArrEqualSumK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> pSum = new HashMap();
        pSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (pSum.containsKey(currSum - k)) {
                count += pSum.get(currSum - k);
            }

            pSum.put(currSum, pSum.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
