package arrays;

import java.util.Arrays;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import apple.laf.JRSUIConstants;


/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int forwardproduct=1;
        int [] result1 = new int[nums.length];
        result1[0]=1;
        for(int i=1 ; i< nums.length ; i ++)
        {
            forwardproduct = forwardproduct *nums[i-1];
            result1[i]= forwardproduct;

        }

        int reverseproduct=1;
        int [] result2 = new int[nums.length];
        result2[nums.length-1]=1;
        for(int i=nums.length-2 ; i>=0 ; i --)
        {
            reverseproduct = reverseproduct *nums[i+1];
            result2[i]= reverseproduct;
        }

        int [] result = new int[nums.length];
        for(int i=0; i < nums.length ; i++)
        {
            result[i] = result1[i]*result2[i];
        }

        return  result;

    }

    public static void main(String[] args) {
        int [] nums = new int[] {-1,1,0,-3,3};

        int [] result =  productExceptSelf(nums);
        //System.out.println("re " + result.length);
        for(int j : result)
        {
            System.out.print(j  + ", ");
        }
    }

}
