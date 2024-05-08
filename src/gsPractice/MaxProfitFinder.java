package gsPractice;

public class MaxProfitFinder {
    public static void main(String[] args) {
        int[] prices = {23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17};
        int money = 20;

        int bestBuyPrice = 0;
        int bestSellPrice = 0;
        int maxProfit = 0;
        int profit = 0;

        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<=money && prices[i+1]>prices[i]){
                profit = prices[i+1] - prices[i];
                if(maxProfit<profit){
                    maxProfit = profit;
                    bestBuyPrice = prices[i];
                    bestSellPrice = prices[i+1];
                }
            }
        }

        System.out.println(bestSellPrice+" "+bestBuyPrice+ " "+maxProfit);

    }
}