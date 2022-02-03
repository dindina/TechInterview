package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/*
In an alien language, surprisingly, they also use English lowercase letters,
but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language,
and the order of the alphabet,
return true if and only if the given words are sorted lexicographically
in this alien language.
 */

public class VerifyingAlienDictionary {
    public static void main(String[] args) {
        String [] words = new String[]{"hell","hello"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isSorted(words,order));
    }

    private static boolean isSorted(final String[] words, final String order) {

        Map<Character,Integer> map = new HashMap<>();
        for(int i =0; i < order.length(); i++)
            map.put(order.charAt(i),i);
        //System.out.println(map);

        // use the map to compare the strings in the arrays
        for(int i= 1 ; i < words.length ; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            if(compareString(prev,curr,map) >0)
                return false;
        }
        return true;
    }

    private static int compareString(final String str1, final String str2, final Map<Character, Integer> map) {

        int i=0;
        int j=0;
        int compareValue = 0;
        while( i< str1.length() && j < str2.length() && compareValue==0)
        {
            compareValue = map.get(str1.charAt(i)) - map.get(str2.charAt(j));
            i++;
            j++;
        }
        if(compareValue == 0)
            return str1.length() - str2.length();
        else
            return compareValue;

    }

}
