package arrays;

public class BestTimetoBuyAStockIII {

    public int maxProfit(int[] prices) {
        int maxProfit1 = 0;
        int min1 = Integer.MAX_VALUE;

        int maxProfit2 = 0;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i < prices.length ; i++)
        {
            // first transaction
            min1 = Math.min(min1,prices[i]);
            maxProfit1 = Math.max(maxProfit1,prices[i]-min1);

            // second transaction
            min2 = Math.min(min2,prices[i]-maxProfit1);
            maxProfit2 = Math.max(maxProfit2,prices[i]-min2);

        }

        return maxProfit2;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(new BestTimetoBuyAStockIII().maxProfit(prices));

    }
}
