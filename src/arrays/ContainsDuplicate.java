package arrays;

import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {


        Set<Integer> set = new HashSet<>();
        for(int i=0; i < nums.length; i++)
        {
            if(set.add(nums[i]) == false)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(prices));

        prices = new int[]{7,1,5,3,6,4};
        System.out.println(new ContainsDuplicate().containsDuplicate(prices));

        prices = new int[]{7,6,4,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(prices));
    }
}
