package twopointers;

public class RemoveDuplicatesFromArrayInPlace {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 1, 3, 5, 5, 7 };
        int newLength = removeDuplicates(nums);
        System.out.println("newLength " + newLength);

        /*for(int i=0; i< nums.length; i++)
        {
            System.out.println(nums[i]);
        }*/
    }

    private static int removeDuplicates(int[] nums) {


        int n = nums.length;

        /*
         * This index will move only when we modify the array in-place to include a new
         * non-duplicate element.
         */
        int j = 0;

        for (int i = 0; i < n; i++) {
            /*
             * If the current element is equal to the next element, then skip the current
             * element because it's a duplicate.
             */

            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            nums[j++] = nums[i];
        }

        //return j;

        for(int i=0; i< nums.length; i++)
        {
            System.out.println(nums[i]);
        }
        return j;

    }



}
