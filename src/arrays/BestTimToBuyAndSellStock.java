package arrays;

public class BestTimToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
        }

        public static int maxProfit(int[] nums) {

            int max=0;
            int lowestBuyPrice=nums[0];

            for(int price : nums)
            {
                if(price < lowestBuyPrice)
                {
                    lowestBuyPrice = price;
                }

                max = Math.max(max,price-lowestBuyPrice);
            }

            return max;
        }

}

