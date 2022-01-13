package slidingwindow;

import java.util.HashSet;
import java.util.Set;

//Given a string s, find the length of the longest substring without repeating characters.
/*Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.*/
// sliding window

public class LongestSubStringWithoutRepeating<maxlength> {

    public static void main(String[] args) {
        String str = "abcabcbb"; // solution abc
        System.out.println(solution(str));

    }

    private static int solution(final String str) {
        int maxlength = 0;
        int windowend = 0, windowstart = 0;

        Set<Character> set = new HashSet<>();
        for(windowend=0;windowend<str.length();windowend++)
        {
            if (!set.contains(str.charAt(windowend))) {
                set.add(str.charAt(windowend++));
                maxlength = Math.max(maxlength, set.size());
            } else { // moving the window and removing from the set
                set.remove(str.charAt(windowstart++));
            }

        }
        return maxlength;

    }

}



