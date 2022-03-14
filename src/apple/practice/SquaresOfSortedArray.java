package apple.practice;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int [] nums = new int[] { 1,3,4,65,778};

    }

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left=0;
        int right= nums.length-1;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(Math.abs(nums[right]) > Math.abs(nums[left]))
            {
                result[i] = nums[right]*nums[right];
                right--;
            }
            else
            {
                result[i] = nums[left]*nums[left];
                left++;
            }

        }

        return result;


    }

}
