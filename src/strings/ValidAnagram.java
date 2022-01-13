package strings;

import java.util.Arrays;


public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;
       int[] alphabets = new int[256];
       for(int i=0 ; i < s.length() ; i++)
       {
           alphabets[s.charAt(i)]++;
           alphabets[t.charAt(i)]--;
       }
        for(int i : alphabets)
        {
            if(i != 0)
                return false;
        }
        return true;

    }





    public static void main(String[] args) {
        System.out.println(isAnagram("4$%","%$4"));
    }


}
