package apple.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutations2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new permutations2().perm(nums));

    }

    private List<List<Integer>> perm(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack_perm(nums,result,new ArrayList<>(),used);
        return result;
    }

    private void backtrack_perm(int[] nums, List<List<Integer>> result, ArrayList<Integer> objects,boolean[] used) {
        if(objects.size() == nums.length)
        result.add(new ArrayList<>(objects));

        for(int i=0; i< nums.length; i++)
        {       if(used[i] || i >0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;

            objects.add(nums[i]);
                backtrack_perm(nums, result, objects,used);
                used[i]=false;
                objects.remove(objects.size() - 1);

        }
    }
}
