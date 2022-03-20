package apple.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(nums,result,new ArrayList<>(),target,set);
        //System.out.println(result);
        return result;
    }
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list , int target, HashSet set)
    {
        if(list.size()==4) {
            //System.out.println(list);
            int sum = 0;
            String val ="";
            for (int i : list) {
                sum += i;
                val = i+":"+val;

            }
            if (sum == target) {

                if(!set.contains(val)) {
                    //System.out.println(val);
                    result.add(new ArrayList<>(list));
                }
                else
                    set.add(val);

            }
        }

        for(int i=0; i < nums.length ; i++)
        {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums,result,list,target,set);
            list.remove(list.size()-1);
        }

    }



    public static void main(String[] args) {
        int [] nums = new int[] {1,2,0,-3};
        System.out.println(new FourSum().fourSum(nums,0));
    }

}
