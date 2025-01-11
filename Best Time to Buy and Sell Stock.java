class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0) return 0;

        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price:prices){
            if(price < minPriceSoFar){
                minPriceSoFar = price;
            }

            int profit = price - minPriceSoFar;

            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
