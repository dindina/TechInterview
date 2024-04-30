package arrays;

public class LeftRotateArrayDplaces {

    public static void main(String[] args) {
        int[] nums = new int[] { -1,-100,3,99};
        int d = 2;
        d = d%nums.length;
        System.out.println("d "+d) ;
        printArray(nums);
        //reverseArray(nums,0,nums.length-1);
        //printArray(nums);
        System.out.println();
        //rotateLeftArray(nums,d);
        rotateLeftArray(nums,d);
        printArray(nums);


    }

    public static void rotateLeftArray(int []nums , int d)
    {
        reverseArray(nums,0,d-1);
        reverseArray(nums,d,nums.length-1);
        reverseArray(nums,0,nums.length-1);


    }
    public static void rotateRightArray(int []nums , int d)
    {
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,d-1);
        reverseArray(nums,d,nums.length-1);



    }

    public static void reverseArray(int[] arr , int start , int end)
    {
        while(start<=end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void printArray(int []arr)
    {
        for(int i:arr)
        {
            System.out.print(i+",");
        }
        System.out.println();
    }
}
