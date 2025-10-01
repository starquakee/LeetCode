public class num1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=0;
        int empty=0;
        while (true){
            ans+=numBottles;
            empty+=numBottles;
            if(empty<numExchange){return ans;}
            numBottles=empty/numExchange;
            empty=empty%numExchange;
        }
    }
}
