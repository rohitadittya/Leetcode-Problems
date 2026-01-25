package two_pointer.arrays;

/*
    42. Trapping Rain Water | Hard
    https://leetcode.com/problems/trapping-rain-water/description/

    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
 */
public class LC42_TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length, trappedSum = 0;
        int lMax[] = new int[n], rMax[] = new int[n];

        lMax[0] = height[0];
        rMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
            rMax[j] = Math.max(rMax[j + 1], height[j]);
        }

        for (int i = 0; i < n; i++) {
            trappedSum += (Math.min(lMax[i], rMax[i]) - height[i]);
        }

        return trappedSum;
    }
}
