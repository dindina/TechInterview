package strings;

import java.util.HashMap;
import java.util.Map;


public class MaximumLengthOfNonRepeatingSubstring {


    public static int getMaxLength_SlidingWindow(String str)
    {
        if(str.length() <=1)
            return str.length();
        int maxLength = 0;
        int left=0;
        int right=0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(right=0 ; right < str.length(); right++)
        {
            char currentChar = str.charAt(right);
            Integer index = charMap.get(currentChar);
            if(index!=null && index >= left) // condition when to move left pointer
            {
                left = index +1;
            }
            charMap.put(currentChar,right);
            // right-left+1 is the length of the substring

            maxLength = Math.max(right-left+1,maxLength);
        }


        return maxLength;

    }

    public static int getMaxLengthBruteForce(String str)
    {
        if(str.length() <=1)
            return str.length();
        int maxLength = 0;
        int right =0;
        for(int left=0 ; left < str.length(); left++)
        {
            int currentLen = 0;
            Map<Character,Boolean> seenChars = new HashMap<>();
            for(right=left ; right< str.length() ; right++)
            {
                 char currentChar = str.charAt(right);
                 if(!seenChars.containsKey(currentChar))
                 {
                     currentLen++;
                     seenChars.put(currentChar,true);
                     maxLength = Math.max(currentLen,maxLength);
                 }
                 else
                     break;

            }

        }


        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(getMaxLengthBruteForce("abc"));
        System.out.println(getMaxLengthBruteForce("abcd"));
        System.out.println(getMaxLengthBruteForce("abcdddefghij"));
        System.out.println(getMaxLengthBruteForce("abcccmadrasbbbbbb"));
        System.out.println(getMaxLength_SlidingWindow("abc"));
        System.out.println(getMaxLength_SlidingWindow("abcd"));
        System.out.println(getMaxLength_SlidingWindow("abcdddefghij"));
        System.out.println(getMaxLength_SlidingWindow("abcccmadrasbbbbbb"));
    }
}
