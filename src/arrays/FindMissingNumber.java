package arrays;

/*

Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Examples
Example 1:
Input Format:
 N = 5, array[] = {1,2,4,5}
Result:
 3
Explanation:
In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format:
 N = 3, array[] = {1,3}
Result:
 2
Explanation:
In the given array, number 2 is missing. So, 2 is the answer.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,6};
        System.out.println(nums.length);
        int sumOfN = ((nums.length+1)*(nums.length+2))/2;
        System.out.println("sumOfN " + sumOfN);
        int sum=0;
        for(int i=0 ; i< nums.length;i++)
        {
            sum+=nums[i];
        }
        int missingnumber = sumOfN-sum;
        System.out.println("miss " + missingnumber);
    }

}
