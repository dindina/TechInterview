package slidingwindow;

public class LongestSubStringWithDistinctCharacters {

    public static void main(String[] args) {
        String str = "abc1456789";
        System.out.println(LongestSubStringWithDistinctCharacters.findLongestSubStringWithOutRepeatingCharSizeK(str,3));

        System.out.println(isUnique(str));

    }

    private static String findLongestSubStringWithOutRepeatingCharSizeK(final String str, int k) {

        String result = null;
        
        int windowstart=0;
       
        StringBuilder windowString = new StringBuilder();
        for(int windowend=0; windowend < str.length() ; windowend++ )
        {
            windowString.append(str.charAt(windowend));
            if(windowend-windowstart+1 ==k )
            {
                //isUnique(w)
                windowstart++;
            }


            
        }

        return result;
    }

    private static boolean isUnique(final String str) {

        boolean[] flags = new boolean[256];
        char[] chararray = str.toCharArray();
        for(int i=0; i< chararray.length ;i++)
        {
            if(flags[chararray[i]] == true)
                return false;
            flags[chararray[i]] = true;
        }
        return true;
    }
}
