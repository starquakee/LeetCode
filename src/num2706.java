public class num2706 {
    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int price:prices){
            if(min>=price){
                min2 = min;
                min = price;
            }else if(price<min2){
                min2 = price;
            }
        }
        if(min+min2<=money)return money-min-min2;
        return money;
    }
}
