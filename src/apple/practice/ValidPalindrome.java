package apple.practice;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s==null) return false;
        if(s.equals("")) return true;
        s= s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left<=right)
        {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("race1car"));
        System.out.println(new ValidPalindrome().isPalindrome("cb aa bc"));
        System.out.println(new ValidPalindrome().isPalindrome("race car"));
        System.out.println(new ValidPalindrome().isPalindrome(" racecar"));
        System.out.println(new ValidPalindrome().isPalindrome("     12"));

    }
}
