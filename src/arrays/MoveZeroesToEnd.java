package arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,4,6,0,0,6,1};
        ArrayUtil.printArray(nums);
        movezeroes(nums);
        ArrayUtil.printArray(nums);
    }
    public static void movezeroes(int []nums)
    {
        int j=-1;
        for(int i=0 ; i<nums.length; i++)
        {
            if(nums[i]==0)
            {
                j=i;
                break;
            }
        }

        for(int i=j+1; i <nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }



}
