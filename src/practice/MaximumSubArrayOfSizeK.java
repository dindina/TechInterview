package practice;

import java.util.HashMap;

public class MaximumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0};
        int K=0;
        System.out.println(new MaximumSubArrayOfSizeK().findCount(nums,K));
    }

    private int findCount(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        //map.put(0, 1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
            System.out.println(map);
        }
        return count;
    }

}
