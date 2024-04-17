package slidingWindow;

import java.nio.channels.Pipe;

public class BestTimeBuySellStocks {

    static public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int buyingPrice = prices[i];
            for (int j = i + 1; j < n; j++) {
                int sellingPrice = prices[j];
                if (sellingPrice > buyingPrice) {
                    maxProfit = Math.max(maxProfit, sellingPrice - buyingPrice);
                }
            }
        }

        return maxProfit;
    }

    static public int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        int currProfit = 0;
        int buyPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
            else{
                currProfit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 6, 4, 3, 1 };
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}
