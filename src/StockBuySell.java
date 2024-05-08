import java.util.ArrayList;
import java.util.List;

public class StockBuySell {
    public static void main(String[] args) {
//        List<Integer> stockPrices = List.of(4, 2, 2, 4, 2);
        List<Integer> stockPrices = List.of(100, 180, 260, 310, 40, 535, 695);
        int maxProfit = 0;

        List<StockInfo> stockInfos = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;

        int i = 0;
        while (i < stockPrices.size()) {
            if (i < stockPrices.size() - 1 && stockPrices.get(i) < stockPrices.get(i + 1)) {
                maxProfit += stockPrices.get(i + 1) - stockPrices.get(i);
                endIndex = i + 1;
            } else {
                if (endIndex > startIndex) {
                    StockInfo stockInfo = new StockInfo(startIndex, endIndex, stockPrices.get(endIndex) - stockPrices.get(startIndex));
                    stockInfos.add(stockInfo);
                }
                startIndex = i + 1;
            }
            i++;
        }

        System.out.println("maxProfit " + maxProfit);
        System.out.println(stockInfos);
    }


}

class StockInfo {
    private int buy;
    private int sell;
    private int profit;

    public StockInfo(int buy, int sell, int profit) {
        this.buy = buy;
        this.sell = sell;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "buy=" + buy +
                ", sell=" + sell +
                ", profit=" + profit +
                '}';
    }
}