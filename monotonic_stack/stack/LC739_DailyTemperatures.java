package monotonic_stack.stack;

import java.util.Stack;

/*
    739. Daily Temperatures
    https://leetcode.com/problems/daily-temperatures/

    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:
    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]

    Example 2:
    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]
    
    Example 3:
    Input: temperatures = [30,60,90]
    Output: [1,1,0]
*/

public class LC739_DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nxtGtTemp = new Stack<>();
        int[] res = new int[temperatures.length];

        /*
            This stack is decreasing monotonic stack,
            Elements inside the stack always maintains decreasing order, 
            while inserting new elements all the smaller eles are removed
         */
        for (int i = 0; i < temperatures.length; i++) {
            while (!nxtGtTemp.isEmpty() && temperatures[i] > temperatures[nxtGtTemp.peek()]) {
                int ind = nxtGtTemp.pop();
                res[ind] = i - ind;
            }

            nxtGtTemp.push(i);
        }

        return res;
    }
}
