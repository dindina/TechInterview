package practice;

/**
 * /*
 * Problem Statement
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 *
 *
 * Input: text = forxxorfxdofr, word = for
 * Output : 3
 *
 *
 *  */

public class AnagramCheck {
    public static void main(String[] args) {
        String str1= "msa";
        String str2= "sam";
        //System.out.println(isAnagram(str1,str2));
        System.out.println(countAnagrams("forxxorfxdofr","for"));
        System.out.println(countAnagrams("for","for"));
        System.out.println(countAnagrams("forfor","for"));

    }

    public static int countAnagrams(String str, String word )
    {
        int left =0;
        int count =0;
        int wordCount = word.length();
        for(int right=0; right <str.length();right++) {

            if(right-left+1 == wordCount) {
                String anagram = str.substring(left,right+1);
                if(isAnagram(anagram,word))
                {
                    count++;
                }
                left++;
            }
        }
        return count;

    }

    public static boolean isAnagram(String str1,String str2)
    {
        int [] array = new int[256];
        for(int i=0 ; i <str1.length();i++)
        {
            int index = str1.charAt(i);
            array[index]=1;


        }
        for(int i=0 ; i <str2.length();i++)
        {
            int index = str2.charAt(i);
            array[index]= array[index]-1;

        }

        for(int i=0 ; i <array.length;i++) {
            if (array[i] !=0)
                return false;
        }

        return true;
    }
}
