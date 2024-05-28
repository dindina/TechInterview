package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1};
        System.out.println(threesum(nums));

    }

    static List<List<Integer>> threesum(int nums[])
    {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++)
        {
            int left=i;
            int right= nums.length-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                System.out.println("sum " +sum);
                if(sum==0)
                {
                    System.out.println("in");
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    String uniqueval =nums[i] +":"+nums[left]+":"+":"+nums[right];
                    if(!set.contains(uniqueval)) {
                        result.add(temp);
                        set.add(uniqueval);
                    }
                    left++;
                    right--;

                } else if (sum<0) {
                    left++;
                }
                else {
                    right--;
                }

            }
            }
        return result;
        }


}
