import java.util.Arrays;
import java.util.Comparator;

public class num1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n=events.length;
        int[][] dp =new int[n+1][k+1];
        for(int i=0;i<n;i++){
            int pre=binarySearch(events,events[i][0]);
            for(int j=1;j<=k&&j<=i+1;j++){
                dp[i+1][j]=Math.max(dp[i][j],dp[pre+1][j-1]+events[i][2]);
            }
        }
        return dp[n][k];
    }
    public int binarySearch(int[][]events,int target){
        int l=0,r=events.length-1;
        int ans=0;
        while (l<=r){
            int mid=(l+r)/2;
            if(events[mid][1]<target){
                l=mid+1;
                ans=Math.max(ans,mid);
            }else r=mid-1;
        }
        return ans;
    }
}
