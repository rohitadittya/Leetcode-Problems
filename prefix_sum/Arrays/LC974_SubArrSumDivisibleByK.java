package prefix_sum.Arrays;

import java.util.HashMap;

/*
    Day 2 | Problem 6
    LC 974. Subarray Sums Divisible by K | Medium
    https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

    Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

    A subarray is a contiguous part of an array.

    Example 1:
    Input: nums = [4,5,0,-2,-3,1], k = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by k = 5:
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    
    Example 2:
    Input: nums = [5], k = 9
    Output: 0
*/

public class LC974_SubArrSumDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        int currSum = 0, count = 0;
        HashMap<Integer, Integer> pRmndrs = new HashMap();
        pRmndrs.put(0, 1);

        /*
            Note: We can further optimize by using array (i.e arr[size = k]) and use that as map
         */
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int remainder = currSum % k;

            if (remainder < 0) {
                remainder = (remainder + k) % k;
            }

            if (pRmndrs.containsKey(remainder)) {
                count += pRmndrs.get(remainder);
            }

            pRmndrs.put(remainder, pRmndrs.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
