package practice;

public class FindRotationIndex {
    public static void main(String[] args) {
        int [] nums = new int[] {5,6,7,1,2,3,4};
        System.out.println("final " + findRotIndex(nums));
    }

    private static int findRotIndex(int[] nums) {

        int left=0;
        int right=nums.length-1;

        while(left<=right)
        {
            int mid = left + (right-left)/2;
            System.out.println("mid " + mid);
            System.out.println("nums[mid] " + nums[mid]);
            System.out.println("mid[mid+1] " + nums[mid+1]);
            if(nums[mid] > nums[mid+1])
            {
                return mid+1;
            }
            if(nums[mid] < nums[left])
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }

        }
        return -1;
    }


}
