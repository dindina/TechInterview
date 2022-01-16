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
public class Palindrome2 {

    public static void main(String[] args) {
        String str1 = "abba";
        System.out.println("final " + validPalindrome(str1));

    }

    public static boolean validPalindrome(String str) {

        int i=0;
        int j = str.length()-1;

        while(i <=j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return (check(str,i+1,j) || check(str,i,j-1));
            }
            i++;
            j--;

        }
        return true;

    }

    static boolean check(String str, int p1 , int p2)
    {
        int i=p1;
        int j = p2;

        while(i <=j)
        {
            if (str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;


    }
}


