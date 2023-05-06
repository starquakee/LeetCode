public class num2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans=logs[0][0];
        int max=logs[0][1];
        for(int i=1;i< logs.length;i++){
            if(logs[i][1]-logs[i-1][1]>max){
                max=logs[i][1]-logs[i-1][1];
                ans=logs[i][0];
            }
            if(logs[i][1]-logs[i-1][1]==max){
                ans=Math.min(ans,logs[i][0]);
            }
        }
        return ans;
    }
}
