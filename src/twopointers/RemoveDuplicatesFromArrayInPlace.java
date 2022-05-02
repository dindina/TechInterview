package twopointers;

public class RemoveDuplicatesFromArrayInPlace {

    public static void main(String[] args) {
        int[] nums = new int[] {  1, 1, 3, 5, 5, 7 };
        int newLength = removeDuplicates(nums);
        System.out.println("newLength " + newLength);

        /*for(int i=0; i< nums.length; i++)
        {
            System.out.println(nums[i]);
        }*/
    }

    private static int removeDuplicates(int[] nums) {

        int j = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {

            if (nums[i] != nums[j]) {
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }



}
