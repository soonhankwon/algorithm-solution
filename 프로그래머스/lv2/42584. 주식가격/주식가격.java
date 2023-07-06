import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
    public int[] solution(int[] prices) {
        
        ArrayList<Stock> stocks = new ArrayList<>();
        ArrayList<Stock> result = new ArrayList<>();
        int sequence = 0;
        for (int price : prices) {
            for(Iterator<Stock> iterator = stocks.iterator(); iterator.hasNext();) {
                Stock stock = iterator.next();
                if(stock.getPrice() <= price) {
                    stock.increasePeriodNotFalling();
                } else {
                    stock.increasePeriodNotFalling();
                    result.add(stock);
                    iterator.remove();
                }
            }
            stocks.add(new Stock(++sequence, price));
        }

        stocks.addAll(result);
        stocks.sort(Stock::compareTo);

        return stocks.stream().mapToInt(Stock::getPeriodNotFalling).toArray();
    }

    private static class Stock implements Comparable<Stock>{

        private int id;
        private final int price;
        private int periodNotFalling;

        public Stock(int id, int price) {
            this.id = id;
            this.price = price;
            this.periodNotFalling = 0;
        }

        public int getPrice() {
            return price;
        }

        public int getPeriodNotFalling() {
            return periodNotFalling;
        }

        public void increasePeriodNotFalling() {
            this.periodNotFalling++;
        }

        @Override
        public int compareTo(Stock o) {
            return this.id - o.id;
        }
    }
}