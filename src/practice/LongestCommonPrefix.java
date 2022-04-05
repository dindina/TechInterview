package practice;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{
                "flower","flow","flight"
        };

        System.out.println(new LongestCommonPrefix().findPrefix(strs));
    }

    private String findPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int i=1;i< strs.length;i++)
        {
            while(strs[i].indexOf(prefix.toString())!=0)
                prefix.deleteCharAt(prefix.length()-1);

        }
        return prefix.toString();

    }
}
