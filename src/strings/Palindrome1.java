package strings;
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 */
public class Palindrome1 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("final " + isValidPalindrome(str));
        String str1 = "malalam";
        System.out.println("final " + isValidPalindrome(str1));

    }

    public static boolean charCheck1(char ch)
    {
        return !Character.isLetterOrDigit(ch);
    }

    public static boolean isValidPalindrome(String str) {

        String alteredString  = new String();
        for(char ch : str.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
                alteredString +=ch;
            }
        }
        alteredString = alteredString.toLowerCase();
        int i=0;
        int j = alteredString.length()-1;
        while(i< alteredString.length() && j >=0 )
        {
            if(alteredString.charAt(i) != alteredString.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
