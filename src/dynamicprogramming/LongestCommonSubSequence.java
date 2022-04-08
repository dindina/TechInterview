package dynamicprogramming;

public class LongestCommonSubSequence {
        public int longestCommonSubsequence(String str1, String str2) {
          int[][] dp = new int[str1.length() + 1][str2.length() + 1];
          for (int col = str2.length() - 1; col >= 0; col--) {
                for (int row = str1.length() - 1; row >= 0; row--) {
                    if (str1.charAt(row) == str2.charAt(col)) {
                        dp[row][col] = 1 + dp[row + 1][col + 1];
                    } else {
                        dp[row][col] = Math.max(dp[row + 1][col], dp[row][col + 1]);
                    }
                }
            }
         return dp[0][0];
    }
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubSequence().longestCommonSubsequence("dinesh","fine"));

    }
}
