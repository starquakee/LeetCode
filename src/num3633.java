public class num3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landDuration.length;
        int m=waterDuration.length;
        int landFinishTime=Integer.MAX_VALUE;
        int waterFinishTime=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            landFinishTime=Math.min(landFinishTime, landStartTime[i] + landDuration[i]);
        }
        for(int i=0;i<m;i++) {
            ans=Math.min(ans, Math.max(landFinishTime, waterStartTime[i]) + waterDuration[i]);
        }
        for(int i=0;i<m;i++) {
            waterFinishTime=Math.min(waterFinishTime, waterStartTime[i] + waterDuration[i]);
        }
        for(int i=0;i<n;i++) {
            ans=Math.min(ans, Math.max(waterFinishTime, landStartTime[i]) + landDuration[i]);
        }
        return ans;
    }
}
