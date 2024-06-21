public class lcp61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] trendA = new int[temperatureA.length];
        int[] trendB = new int[temperatureA.length];

        for (int i = 0; i < temperatureA.length-1; i++) {
            trendA[i] = temperatureA[i] - temperatureA[i+1];
            trendB[i] = temperatureB[i] - temperatureB[i+1];
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < temperatureA.length-1) {
            if((trendA[right]>0 && trendB[right]>0)||(trendA[right]<0 && trendB[right]<0)||(trendA[right]==0 && trendB[right]==0)){ // 两者趋势相同
                right++;
            }else{
                ans = Math.max(ans,right-left);
                left = right+1;
                right++;
            }

        }
        ans = Math.max(ans,right-left);
        return ans;
    }
}
