package frequency_map.hashmap;

import java.util.Arrays;

/*
    242. Valid Anagram | Easy 
    https://leetcode.com/problems/valid-anagram/

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false
 */
public class LC242_ValidAnagram {

    // Solution 1:
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] stFreq = new char[26];

        for (int i=0; i<s.length(); i++) {
            stFreq[s.charAt(i)-'a']++;
        }

        for (int i=0; i<s.length(); i++) {
            stFreq[t.charAt(i)-'a']--;

        }
    
        for (int i=0; i<26; i++) {
            if (stFreq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // Solution 2:
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        String st1 = new String(str1);
        String st2 = new String(str2);

        return st1.equals(st2);
    }
}
