package apple.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeat {

    public int lengthOfLongestSubstringSet(String s) {
        int windowend=0;
        int maxlen=0;
        Set<Character> set = new HashSet<>();
        for(int windowstart=0; windowstart < s.length(); windowstart++ )
        {
            if(!set.contains(s.charAt(windowstart)))
            {
                set.add(s.charAt(windowstart));
                maxlen = Math.max(maxlen,set.size());
            }
            else
            {
                set.remove(s.charAt(windowend++));
            }

        }
        return maxlen;




    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        
        int windowend=1;
        int maxlen=0;
        for(int windowstart=0; windowstart < s.length(); windowstart++)
        {
            int count=windowend;
            int len=0;
            while(count <= s.length() && isUnique(s.substring(windowstart,count)))
            {
                len++;
                count++;

            }
            maxlen = Math.max(maxlen,len);
            windowend++;

        }
        return maxlen;
    }
    public static boolean isUnique(String str)
    {
        //System.out.println(str);
        int[] chararray = new int[256];
        for(int i=0; i <str.length();i++) {
            int char1 = str.charAt(i);
            //System.out.println(char1);
            chararray[char1] += chararray[char1]+1;
            if(chararray[char1] >1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "12 12  1234";
        //System.out.println(isUnique("abca"));
        System.out.println("1 " + new LongestSubStringWithoutRepeat().lengthOfLongestSubstring(str));
        System.out.println("2 " + new LongestSubStringWithoutRepeat().lengthOfLongestSubstringSet(str));

    }
}
