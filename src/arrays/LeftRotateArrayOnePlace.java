package arrays;

public class LeftRotateArrayOnePlace {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,4,5,7};
        int first= nums[0];
        printArray(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            nums[i]=nums[i+1];
        }
        nums[nums.length-1]=first;
        printArray(nums);

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
