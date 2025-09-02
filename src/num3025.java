import java.util.Arrays;

public class num3025 {
//    public int numberOfPairs(int[][] points) {
//        int ans=0;
//        for(int i=0;i<points.length;i++){
//            for(int j=0;j<points.length;j++){
//                if(i==j) continue;
//                if(points[j][0]<=points[i][0] && points[i][1]<=points[j][1]){
//                    boolean flag=true;
//                    for(int k=0;k<points.length;k++){
//                        if(k==i||k==j) continue;
//                        if(points[k][0]<=points[i][0] && points[k][0]>=points[j][0]&&points[k][1]>=points[i][1]&&points[k][1]<=points[j][1]){
//                            flag=false;
//                            break;
//                        }
//                    }
//                    if(flag) ans++;
//                }
//            }
//        }
//        return ans;
//    }
    public int numberOfPairs(int[][] points) {
        int ans=0;
        Arrays.sort(points, (a, b) -> {
            if(a[0]!=b[0])return b[0]-a[0];
            else return a[1]-b[1];
        });
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[j][0]<=points[i][0] && points[i][1]<=points[j][1]){
                    boolean flag=true;
                    for(int k=i+1;k<points.length;k++){
                        if(k==j) continue;
                        if(points[k][0]<=points[i][0] && points[k][0]>=points[j][0]&&points[k][1]>=points[i][1]&&points[k][1]<=points[j][1]){
                            flag=false;
                            break;
                        }
                    }
                    if(flag) ans++;
                }
            }
        }
        return ans;
    }
}
