package twopointers;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
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

        int slowPointer = 0;
        int fastPointer = 0;
        while (fastPointer < nums.length) {
            if (nums[slowPointer] != nums[fastPointer]) {
                nums[++slowPointer] = nums[fastPointer];
            }
            fastPointer++;
        }
        return slowPointer + 1;
    }



}
