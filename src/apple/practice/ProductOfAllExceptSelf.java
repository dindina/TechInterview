package apple.practice;

import static arrays.ProductOfArrayExceptSelf.printArray;

public class ProductOfAllExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,0,-4};

        printArray(new ProductOfAllExceptSelf().productExceptSelf(nums));

    }
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];

        int forward_product = 1;
        result1[0]=1;
        for(int i=1 ; i<= nums.length-1;i++)
        {
            forward_product = forward_product * nums[i-1]; // previous number
            result1[i] = forward_product;
        }
        System.out.println("forward");
        printArray(result1);

        int reverse_product = 1;
        result2[nums.length-1]=1;
        for(int i=nums.length-2 ; i >= 0;i--)
        {
            reverse_product = reverse_product * nums[i+1]; // previous number
            result2[i] = reverse_product;
        }
        System.out.println("reverse");
        printArray(result2);

        for(int i=0; i < nums.length ; i++)
            result[i] = result1[i]*result2[i];


        return result;
    }
}
