package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/partition-equal-subset-sum/
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class EqualSubSetsSum {
    int totalsum=0;
    public static void main(String[] args) {
        /*int [] nums =new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
                ,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};*/
        int [] nums =new int[]{1,5,11,5};
        System.out.println(new EqualSubSetsSum().canPartition(nums,2));
    }
    public boolean canPartition(int[] nums,int k) {
        boolean result=false;
        int totalsum =0;
        for(int i : nums)
        {
            totalsum+=i;
        }
        System.out.println(totalsum);
        if(totalsum%k !=0) // if the sum is not even
        {
            System.out.println("odd sum");
            return false;
        }
        int currsum=0;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        result =helper(k,0,nums,totalsum/k , currsum , visited);
        return result;

    }

    private boolean helper(int k , int pos, int[] nums, int sum, int currsum, boolean[] visited ) {

        if(k==0) {
            //System.out.println("k "+ k );
            return true;
        }
        if(currsum > sum)
        {
            return false;
        }
        if(currsum==sum)
        {
            return helper(k-1,0,nums,sum,0,visited);
        }

        for(int i=pos; i<nums.length;i++)
        {
            if(visited[i] || currsum+nums[i]>sum) continue;
            visited[i] = true;
            if(helper(k,pos+1,nums,sum,currsum+nums[i] , visited )) return true;
            visited[i] = false;
        }
        return false;
    }
}
