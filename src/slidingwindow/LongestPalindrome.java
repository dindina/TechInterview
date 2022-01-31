package slidingwindow;

/*
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
public class LongestPalindrome {
    public static String longestPalindrome(String str) {

        if(str == null || str.length() ==0 )
        return "";

        int start=0;
        int end=0;

        for(int i=0; i < str.length();i++)
        {
            int len1 = expandFromMiddle(str,i,i);
            //System.out.println("sub " + str.substring(i,i));
            //System.out.println("len1 " + len1);
            int len2 = expandFromMiddle(str,i,i+1);
            //System.out.println("sub " + str.substring(i,i+1));
            //System.out.println("len2 " + len2);
            int len = Math.max(len1,len2);
            System.out.println("sub " + str.substring(0,i));
            System.out.println("max " + len);
            if(len > end-start)
            {
                start = i-((len-1)/2);
                end = i + (len/2);
            }


        }
        return str.substring(start,end+1);

    }
    public static int expandFromMiddle(String str, int left , int right)
    {
        if(str == null || left > right)
            return 0;
        while(left >=0 && right < str.length() && str.charAt(left)==str.charAt(right))
        {
            left--;
            right++;

        }
        return right-left-1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
    }

}
