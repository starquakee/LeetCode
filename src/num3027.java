import java.util.Arrays;

public class num3027 {
    public int numberOfPairs(int[][] points) {
        int ans=0;
        Arrays.sort(points, (a, b) -> {
            if(a[0]!=b[0])return b[0]-a[0];
            else return a[1]-b[1];
        });
        for(int i=0;i<points.length;i++){
            int xMin=points[i][0]+1;
            int yMin=Integer.MAX_VALUE;
            for(int j=i+1;j<points.length;j++){
                if(points[j][0]<=points[i][0] && points[i][1]<=points[j][1]){
                    if(points[j][0]<xMin&&points[j][1]<yMin){
                        xMin=points[j][0];
                        yMin=points[j][1];
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
