package practice;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-5,-1,0,2,6,7};
        int[] sorted = sortedArray(nums);
        for(int i : sorted)
        {
            System.out.println(i);
        }
    }

    private static int[] sortedArray(int[] nums) {
        int left = 0;
        int right= nums.length-1;
        int[] result = new int[nums.length];

        for(int i= nums.length-1 ; i>=0 ; i--)
        {
            if(Math.abs(nums[left]) > Math.abs(nums[right]))
            {
                result[i] = nums[left]*nums[left];
                left++;
            }
            else
            {
                result[i] = nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
