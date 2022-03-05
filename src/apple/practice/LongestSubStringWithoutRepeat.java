package apple.practice;

public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return -1;
        
        int windowend=0;
        int maxlen=0;
        for(int windowstart=0; windowstart < s.length(); windowstart++)
        {
            int count=windowend;
            int len=0;
            while(count < s.length() && isUnique(s.substring(windowstart,count)))
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
        int[] chararray = new int[256];
        for(int i=0; i <str.length();i++) {
            int char1 = str.charAt(i);
            System.out.println(char1);
            chararray[char1] += chararray[char1]+1;
            if(chararray[char1] >1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcaabcdef1123456789";
        //System.out.println(isUnique("dae11"));
        System.out.println(new LongestSubStringWithoutRepeat().lengthOfLongestSubstring(str));
    }
}
