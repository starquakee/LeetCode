import java.util.HashMap;
import java.util.TreeMap;

class StockPrice {
    private HashMap<Integer,Integer> map;
    private TreeMap<Integer,Integer> prices;
    private int max;
    private int min;

    private int latest_time;
    public StockPrice() {
        map = new HashMap<>();
        prices = new TreeMap<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        latest_time = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        int prePrice = map.getOrDefault(timestamp,0);
        map.put(timestamp,price);
        max = Math.max(max,price);
        min = Math.min(min,price);
        latest_time = Math.max(latest_time,timestamp);

        if(prePrice>0){
            prices.put(prePrice,prices.get(prePrice)-1);
            if(prices.get(prePrice)==0){
                prices.remove(prePrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(latest_time);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */