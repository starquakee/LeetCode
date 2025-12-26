public class num2483 {
    public int bestClosingTime(String customers) {
        int tempCost=0;
        int ans=0;
        for(char c:customers.toCharArray()){
            if(c=='Y')tempCost++;
        }
        int minCost=tempCost;
        for(int i=1;i<=customers.length();i++){
            if(customers.charAt(i-1)=='Y')tempCost--;
            else tempCost++;
            if(tempCost<minCost){
                minCost=tempCost;
                ans=i;
            }
        }
        return ans;
    }
}
