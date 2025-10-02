public class num3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans=0;
        int empty=0;
        while (true){
            ans+=numBottles;
            empty+=numBottles;
            if(empty<numExchange){return ans;}
            numBottles=1;
            empty=empty-numExchange;
            numExchange++;
        }
    }
}
