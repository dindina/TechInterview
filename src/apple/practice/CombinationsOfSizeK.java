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
public class CombinationsOfSizeK {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> objects, List<List<Integer>> result) {
        if(objects.size()==nums.length)
          result.add(new ArrayList<>(objects));
        for(int i=0; i< nums.length; i++ )
        {
            if(objects.size() >nums.length) continue;

            objects.add(nums[i]);
            backtrack(nums,objects,result);
            objects.remove(objects.size()-1);
        }

    }

    public static void main(String[] args) {
        int [] nums = new int[] {1,2};
        System.out.println(new CombinationsOfSizeK().subsets(nums));
    }
}
