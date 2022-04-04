package apple.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int startpos=0;
        backtrack_subsets(startpos,nums,result, new ArrayList<>());
        return result;
    }

    private void backtrack_subsets(int start, int[] nums, List<List<Integer>> result, ArrayList<Integer> objects) {

        result.add(new ArrayList<>(objects));
        for(int i= start ; i < nums.length; i++)
        {
            if(i >start && nums[i]==nums[i-1]) continue;
            objects.add(nums[i]);
            backtrack_subsets(i+1,nums,result,objects);
            objects.remove(objects.size()-1);

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,5,11};
        System.out.println(new subsets2().subsetsWithDup(nums));
    }

}
