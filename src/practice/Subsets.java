package practice;
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

import apple.practice.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3};
        System.out.println(new subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        int startpos=0;
        backtrakl(startpos,nums,result,new ArrayList<>());
        return result;
    }

    private void backtrakl(int startpos, int[] nums, List<List<Integer>> result, ArrayList<Integer> objects) {
        result.add(new ArrayList<>(objects));
        for(int i= startpos; i< nums.length;i++)
        {
            objects.add(nums[i]);
            backtrakl(startpos+1,nums,result,objects);
            objects.remove(objects.size()-1);
        }
    }


}
