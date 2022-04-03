package backtracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SubsetsOfSumK {
    public static void main(String[] args) {
        int k = 6;
        int [] nums = new int[]{1,2,3,1};
        System.out.println(new SubsetsOfSumK().find(nums,k));

    }

    private List<List<Integer>> find(int[] nums, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack_find(0,nums,result,new ArrayList<>(),k);
        return result;
        }

    private void backtrack_find(int pos, int[] nums, List<List<Integer>> result,
                                ArrayList<Integer> objects, int target) {
        if(target==0)
        result.add(new ArrayList<>(objects));
        for(int i=pos; i< nums.length;i++)
        {
            objects.add(nums[i]);
            backtrack_find(pos+1,nums,result,objects,target-nums[i]);
            objects.remove(objects.size()-1);
        }

    }

}
