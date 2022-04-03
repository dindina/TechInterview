package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,3,4};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
        System.out.println(ans.size());
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i < nums.length; i++)
        {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums,result,list);
            list.remove(list.size()-1);
        }

    }


}
