package apple.practice;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int startpos =0; // starting position of the input array
        backtrack(startpos,nums,new ArrayList<Integer>(),result);
        return result;
    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> objects , List<List<Integer>> result) {

        result.add(new ArrayList<>(objects));
        for(int i=start; i< nums.length; i++ )
        {
            objects.add(nums[i]);
            backtrack(i+1,nums,objects,result);
            objects.remove(objects.size()-1);
        }

    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,5,5,11};
        System.out.println(new subsets().subsets(nums));
    }
}
