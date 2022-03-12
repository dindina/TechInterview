package slidingwindow;

import java.util.Arrays;


/*
Problem Statement
Given a word and a text, return the count of occurrences of the anagrams of the word in the text.


Input: text = forxxorfxdofr, word = for
Output : 3


 */
public class CountAnagrams {

    public static void main(String[] args) {

        System.out.println(countAnagrams("forxxorfxdofr","for"));
        System.out.println(countAnagrams("for","for"));
        System.out.println(countAnagrams("forfor","for"));
    }

    public static int countAnagrams(String givenText,String anagramText)
    {
        int windowstart = 0;
        int windowsize = anagramText.length();
        StringBuffer windowString= new StringBuffer();
        int totalcount=0;
        for(int windowend=0; windowend < givenText.length() ; windowend++)
        {
            windowString.append(givenText.charAt(windowend));
            if(windowend-windowstart+1 == windowsize)
            {
                //System.out.println("inside " +windowString);
                // check if the window string is anagram of anagramText
                if(checkAnagram(windowString,anagramText))
                    totalcount++;

                // reducing the window string
                windowString.deleteCharAt(0);
                windowstart++;
            }

        }
        return totalcount;
    }

    private static boolean checkAnagram(final StringBuffer windowString, final String anagramText) {

        char[] charArray = windowString.toString().toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);

        char[] charArrayAnagram = anagramText.toCharArray();
        Arrays.sort(charArrayAnagram);
        String sortedStringAnagram = new String(charArrayAnagram);

        return sortedString.equals(sortedStringAnagram);

    }

}
