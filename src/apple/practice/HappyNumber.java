package apple.practice;

import java.util.HashSet;

/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {

    public static void main(String[] args) {
        //int num = 19; // any number with digit 1 and 9 will be happy number
        int num = 12;
        //System.out.println(sumofsquares(num));
        System.out.println(isHappy(num));
    }
    //cycle detection using set
    public static boolean isHappy(int num) {
       HashSet <Integer> set = new HashSet<>();
        while(num!=1 && !set.contains(num)) {
            set.add(num);
            System.out.println(num);
            num = sumofsquares(num);


        }
        if(num==1) return true;
        return false;
    }
    public static int sumofsquares(int num)
    {
        int sum =0;

        while(num >0)
        {
            int x = num%10;
            sum+=(x*x);
            num = num /10;

        }
        return sum;
    }
}
