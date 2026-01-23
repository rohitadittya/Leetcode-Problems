package sliding_window.Strings;

import java.util.HashMap;

/*
    LC 3. Longest Substring Without Repeating Characters | Medium 
    https://leetcode.com/problems/longest-substring-without-repeating-characters/

    Given a string s, find the length of the longest substring without duplicate characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
*/

public class LC3_LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap();
        int i = 0, j = 0, len = 0;

        for (; j < s.length(); j++) {
            // Loop thru each char
            if (hm.containsKey(s.charAt(j))) {
                // if the char repeats - then we are moving to the next position of j
                // and changing the i pos to j position
                // eg: P W M W K E W
                // here when j reaches to 3rd ind (W is already present in map) - so we are shifting i to j's position (i.e - index after 1st j ("W") occurence).

                i = Math.max(i, hm.get(s.charAt(j)) + 1);

                // Below logic wont work - think what if the curr j ele is same as i's ele
                // eg: w k e w f -- here when j=3 it will come to this loop, and now a valid case is, i shld move to ind 1 (k). i.e (max(i=0, j=0) + 1); as both are pointing same ele
                // hm.remove(s.charAt(i));
                // i=hm.get(s.charAt(j))+1;
            }

            hm.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
        }

        return len;
    }
}
