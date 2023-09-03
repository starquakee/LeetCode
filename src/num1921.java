import java.util.Arrays;

public class num1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        float[] times = new float[dist.length];
        for(int i=0;i<dist.length;i++){
            times[i] = (float) dist[i]/speed[i];
        }
        Arrays.sort(times);
        int ans = 0;
        for(int i=0;i<times[times.length-1];i++){
            if(i<times[i]){
                ans++;
            }else {
                return ans;
            }
            if(ans==dist.length)return ans;
        }
        return ans;
    }
}
