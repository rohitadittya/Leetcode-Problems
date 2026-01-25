package sliding_window.Strings;

/*
    LC 424. Longest Repeating Character Replacement | Medium
    https://leetcode.com/problems/longest-repeating-character-replacement/description/

    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.
    
    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.
 */
public class LC424_LongestRepeatingCharReplacement {

    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int len = 0, maxFreq = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            chars[s.charAt(r) - 'A']++;

            /*
                maxFreq will have always max freq so that remaining values in the current window can be calculated.
                i.e curr.window - maxFreq gives the #of elements that can be replaced.

                at any point the maxFreq's window (curr.window - maxFreq <= k) will always contain maxLen window.
             */
            maxFreq = Math.max(maxFreq, chars[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxFreq > k && l <= r) {
                chars[s.charAt(l) - 'A']--;
                l++;
            }

            len = Math.max(len, r - l + 1);
        }

        return len;
    }
}
