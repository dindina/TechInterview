package slidingwindow;

public class MaxSumSubArrayWithSizeK {
    public static void main(String[] args) {
        //int array[] = new int[]{1,2,5,6,7,9,-10};
        int array[] = new int[]{5,5,6,7,9};
        int size = 3 ;

        int windowstart=0;
        int maxsum=0;
        int windowsum=0;
        for(int windowend=0; windowend< array.length;windowend++)
        {
            windowsum+=array[windowend];
            if(windowend >= size-1)
            {
                maxsum = Math.max(maxsum,windowsum);
                //System.out.println(windowend  + " , " +  maxsum);
                windowsum -= array[windowstart]; // subtracting from the window
                windowstart++;
            }
        }
        //System.out.println(maxsum);

        slidingWindow(array);
        //findMinimumSizeSubArrayWithGiveSum(array,16);
        //System.out.println(findMinSubArray(1,array));
    }




    //Smallest Subarray with a given sum

    public static void findMinimumSizeSubArrayWithGiveSum(int [] array , int givenSum)
    {
        int windowStart=0;
        int windowSum=0;
        int minimumSize = Integer.MAX_VALUE;

        for(int windowEnd=0; windowEnd< array.length;windowEnd++)
        {
            windowSum += array[windowEnd];
            System.out.println("windowSum " + windowSum);
            while(windowSum > givenSum)
            {
                windowSum -= array[windowStart];
                windowStart++;
            }
            if(windowSum==givenSum)
            {
                //calculate the size of the array
                minimumSize = Math.min(minimumSize,windowEnd-windowStart+1);
                System.out.println("minimumSize " + minimumSize);

            }


        }
        if(minimumSize == Integer.MAX_VALUE) {
            System.out.println("inside");
            minimumSize = 0;
        }
        System.out.println("final minimumSize " + minimumSize);

    }



    //sliding window template
    //Maxsum of size K
    public static void slidingWindow(int [] array)
    {
        int windowstart=0;
        int windowEnd=0;
        int windowsum = 0;
        int maxsum = 0;
        int windowSize = 3;
        for(windowEnd=0; windowEnd< array.length ; windowEnd++)
        {
            windowsum += array[windowEnd];
            if(windowEnd-windowstart +1 == windowSize)
            {
                maxsum = Math.max(maxsum,windowsum);
                System.out.println("max sum at this point " + maxsum);
                // reduce the window sum
                windowsum -= array[windowstart];
                windowstart++;
            }
        }
        System.out.println("final maxsum" + maxsum);

    }
}
