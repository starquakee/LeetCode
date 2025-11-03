public class num1578 {
    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int sum=neededTime[i];
            int max=neededTime[i];
            while (i+1<n&&colors.charAt(i)==colors.charAt(i+1)){
                sum+=neededTime[i+1];
                max=Math.max(max,neededTime[i+1]);
                i++;
            }
            ans+=sum-max;
        }
        return ans;
    }
}
