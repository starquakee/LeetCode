public class num3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans=0;
        int n=bottomLeft.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int subX=Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[j][0],bottomLeft[i][0]);
                int subY=Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[j][1],bottomLeft[i][1]);
                if(subX>0&&subY>0){
                    System.out.println(subX+" "+subY);
                    ans=Math.max(ans,Math.min(subX,subY));
                }
            }
        }
        return ans*ans;
    }
}
