public class num812 {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double ans=0;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                for (int k=j+1;k<n;k++){
                    ans=Math.max(ans,calArea(points[i][0],points[i][1],points[j][0]
                            ,points[j][1],points[k][0],points[k][1]));
                }
            }
        }
        return ans;
    }
    public double calArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (double) Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) /2.0;
    }
}
