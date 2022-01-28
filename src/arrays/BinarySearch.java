package arrays;

public class BinarySearch {

    public int binarySearch(int [] nums , int searchValue)
    {
        int begin = 0;
        int end = nums.length-1;

        while(begin <= end)
        {
            int middleIndex = (begin+end)/2;
            int middleItem = nums[middleIndex];

            if(middleItem == searchValue)
                return middleIndex;
            else if(middleItem > searchValue)
                end = middleIndex-1;
            else
                begin = middleIndex+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,5,6,8,9,11,23,45};
        for(int i: prices)
            System.out.println(new BinarySearch().binarySearch(prices,i));
        System.out.println(new BinarySearch().binarySearch(prices,1000));
    }
}
