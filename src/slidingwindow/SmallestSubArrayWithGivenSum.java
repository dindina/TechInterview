package slidingwindow;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {

        int array[] = new int[]{1,2,2,4,5,2,1,67};
        int sum = 3 ;

        int windowstart=0;
        int windowsum=0;
        int minlen=Integer.MAX_VALUE;
        for(int windowend=0;windowend<array.length;windowend++)
        {
            windowsum+=array[windowend];
            while(windowsum >= sum && windowstart!=array.length)
            {
                minlen = Math.min(minlen,windowend-windowstart+1);
                windowsum-=array[windowstart];
                windowstart++;
            }
        }
        if(minlen !=Integer.MAX_VALUE )
            System.out.println(minlen);

    }

}
