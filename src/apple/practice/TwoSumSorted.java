package apple.practice;

import java.util.EnumSet;

public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right = numbers.length-1;
        int []result = new int[2];
        result[0]=-1;
        result[1]=-1;
        while(left < right)
        {
            int sum = numbers[left]+numbers[right];
            if(sum == target)
            {
                result[0]=left;
                result[1]=right;
                return result;
            }
            else if (target > sum) {
                left++;
            }
            else
            {
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] sorted = new int[]{1};
        int [] result = new TwoSumSorted().twoSum(sorted,1);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
