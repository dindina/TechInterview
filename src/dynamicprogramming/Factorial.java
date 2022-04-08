package dynamicprogramming;

public class Factorial {

    public static void main(String[] args) {

        int dp[] = new int[20];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=0;i<15;i++)
            System.out.println(factorial(i,dp));

    }

    private static int factorial(final int num , int[] dp) {
        if(num ==0)
            return 0;
        for(int i= 1 ; i < num ; i++ )
            dp[i+1] = dp[i]*(i+1);
        return dp[num];
    }
}
