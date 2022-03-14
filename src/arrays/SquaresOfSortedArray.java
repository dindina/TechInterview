package arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int [] nums = new int[] { 1,2,3,4,5};
        int [] result = new SquaresOfSortedArray().SquaresArray(nums);
        for(int i : result)
            System.out.println(i);

    }

    public int[] SquaresArray(int[] nums) {
        int startindex=0;
        int[] result = new int[nums.length];

        int left=0;
        int right=nums.length-1;
        for(int i=nums.length-1; i>= 0 ; i--)
        {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = Math.abs(nums[right])*Math.abs(nums[right]);
                right--;
            }
            else
            {
                result[i] = Math.abs(nums[left])*Math.abs(nums[left]);
                left++;
            }
        }

        //System.out.println(startindex);
        return result;
    }
}
