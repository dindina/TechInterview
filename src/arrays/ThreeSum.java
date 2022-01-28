package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        int left=0;
        int right=0;
        Set<String> set = new HashSet<>();
        for(int i=0; i< nums.length-2 ; i++)
        {
            left=i+1;
            right=nums.length-1;

            while(left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    // found a triplet
                    String str = nums[i] + ":" + nums[left] + ':' + nums[right];
                    if (!set.contains(str)) {
                        row.add(nums[i]);
                        row.add(nums[left]);
                        row.add(nums[right]);
                        result.add(row);
                        row = new ArrayList<>();
                        set.add(str);
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else
                    left++;
            }


            }
            return result;
        }

    public static void main(String[] args) {
        int [] nums = new int[] {-1,0,1,2,-1,-4};
        int target = 0; // just for info
        System.out.println(new ThreeSum().threeSum(nums));

    }

    }



