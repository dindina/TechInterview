package apple.practice;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[]nums = new int[]{-2,0,0,0,2,-5,5,-4,3,1};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int left;
        int right;
        Set<String> set = new HashSet<>();
        for(int i=0; i< nums.length ; i++)
        {
            left=i+1;
            right=nums.length-1;

            while(left < right) {
                int sum =nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // found a triplet
                    String val = nums[i]+":"+nums[left]+":"+nums[right];
                    if(!set.contains(val))
                    {
                        row.add(nums[i]);
                        row.add(nums[left]);
                        row.add(nums[right]);
                        result.add(row);
                        row = new ArrayList<>();
                        set.add(val);
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else
                    right--;
            }
        }
        return result;
    }

}
