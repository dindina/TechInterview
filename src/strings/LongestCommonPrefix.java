package strings;


/*
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("flow".indexOf("flowing"));
        String [] strings = new String[]{"flowing","abc","fl"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));


    }

    public String longestCommonPrefix(String[] strs) {

        StringBuffer prefix = new StringBuffer(strs[0]);
        for(int i=1; i< strs.length;i++)
        {
            String current = strs[i];
            while(current.indexOf(prefix.toString()) !=0)
            {
                prefix.deleteCharAt(prefix.length()-1);
                //System.out.println("prefix " + prefix);
            }
        }
        return prefix.toString();

    }



    }
