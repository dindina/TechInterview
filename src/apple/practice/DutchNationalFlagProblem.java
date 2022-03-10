package apple.practice;

public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int [] nums = new int[]{0,2,2,1,0,};
        dutch(nums);
        for(int i :nums)
        {
            System.out.print(i + ",");
        }
    }
    public static void swap(int [] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void dutch(int[] nums)
    {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high)
        {
            if(nums[mid] == 0)
            {
                swap(nums,mid,low);
                low++;
                mid++;
            }else if(nums[mid]==1) {
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
}
