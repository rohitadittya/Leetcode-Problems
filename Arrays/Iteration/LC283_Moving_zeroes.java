package Arrays.Iteration;

/*
    Day 1 | Problem 2
    LC 283. Move Zeroes | Easy
    https://leetcode.com/problems/move-zeroes/description/

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]
 */
public class LC283_Moving_zeroes {
    public void moveZeroes(int[] nums) {
        int zeroPtr = 0, numPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            /*
            if (nums[zeroPtr] != 0) {
                zeroPtr++;
            }
            if (nums[numPtr] == 0) {
                numPtr++;
            }
            else if (zeroPtr > numPtr) {
                numPtr = zeroPtr;
            }
            
            if (nums[zeroPtr] == 0 && nums[numPtr] !=0) {
                nums[zeroPtr] = nums[numPtr];
                nums[numPtr] = 0;
            }
             */
            if (nums[i] != 0) {
                int temp = nums[zeroPtr];
                nums[zeroPtr] = nums[i];
                nums[i] = temp;
                zeroPtr++;
            }
        }
    }
}
