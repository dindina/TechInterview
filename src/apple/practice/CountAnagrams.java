package apple.practice;

public class CountAnagrams {
    public static void main(String[] args) {

        System.out.println("dinesh".substring(1,3));
        System.out.println(countAnagrams("forxxorfxdofr","for"));
        //System.out.println(countAnagrams("for","for"));
        //System.out.println(countAnagrams("forfor","for"));

    }

    public static int countAnagrams(String s1, String s2)
    {
        // use sliding window
        int windowend=0;
        int windowsize = s2.length();
        StringBuilder windowString = new StringBuilder();
        int count=0;
        for(int windowstart=0; windowstart < s1.length(); windowstart++)
        {
            windowString.append(s1.charAt(windowstart));

            if(windowstart-windowend+1 == windowsize) {
                System.out.println(windowString);
                if (isAnagram(windowString.toString(), s2))
                    count++;
                windowString.deleteCharAt(0);
                windowend++;
            }

        }

        return count;

    }

    static boolean isAnagram(String s1 , String s2)
    {
        int[] charcount = new int[256];
        for(int i=0; i< s1.length() ; i++)
            charcount[s1.charAt(i)] = charcount[s1.charAt(i)] +1;

        for(int i=0; i< s2.length() ; i++)
            charcount[s2.charAt(i)] = charcount[s2.charAt(i)] -1;

        for(int i=0 ; i< charcount.length ;i++)
        {
            if(charcount[i] !=0) return false;
        }

        return true;
    }
}
