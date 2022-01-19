package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;


/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */
public class WordBreak {

    public static boolean wordBreak(String str, List<String> wordDict) {

        int length = str.length();
        boolean dp[] = new boolean[length+1];
        dp[0]=true;
        for(int i=0 ; i <= str.length() ; i++)
            for(int j=0 ; j <i ; j++)
            {
                System.out.println(i+","+j + " " + str.substring(j,i));
                if(dp[j] && wordDict.contains(str.substring(j,i)))
                    dp[i] = true;
            }
        return dp[length];

    }

    public static void main(String[] args) {
        String str = "catsdogcatsand";
        List<String> words = new ArrayList<>();
        //"cats","dog","sand","and","cat"]
        words.add("cats");
        words.add("dog");
        words.add("and");
        words.add("sand");
        words.add("cat");
        System.out.println(wordBreak(str,words));


    }
}
