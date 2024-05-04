package slidingwindow;

import java.util.HashSet;
import java.util.Set;

//Given a string s, find the length of the longest substring without repeating characters.
/*Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.*/
// sliding window

public class LongestSubStringWithoutRepeating{

    public static void main(String[] args) {
        String str = "abcabcd"; // solution abc
        System.out.println(solution(str));

    }

    private static int solution(final String s) {
        if (s == null || s.length() == 0 || s.equals("")) {
            return 0;
        }

        final int[] cPos = new int[256];
        cPos[s.charAt(0)] = 1;

        int slow = 0;
        int maxWindowSize = 1;
        for (int fast = 1; fast < s.length(); fast++) {
            final char c = s.charAt(fast);
            if (cPos[c] != 0) {
                slow = Math.max(slow, cPos[c]);
            }
            cPos[c] = fast+1;
            maxWindowSize = Math.max(fast - slow + 1, maxWindowSize);
        }

        return maxWindowSize;

    }

}



