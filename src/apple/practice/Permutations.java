package apple.practice;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/permutations/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> integers, List<List<Integer>> result) {
        if(integers.size() == nums.length)
            result.add(new ArrayList<>(integers));
        for(int i = 0; i< nums.length;i++)
        {
            if(integers.contains(nums[i])) continue;
            integers.add(nums[i]);
            backtrack(nums,integers,result);
            integers.remove(integers.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3};
        System.out.println(new Permutations().permute(nums));
    }


}
