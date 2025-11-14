public class num2536 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans=new int[n][n];
        int[][] post=new int[n][n];
        for(int[] query:queries){
            int row1=query[0];
            int col1=query[1];
            int row2=query[2];
            int col2=query[3];
            for(int i=row1;i<=row2;i++){
                post[i][col1]++;
                if(col2+1<n){
                    post[i][col2+1]--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                ans[i][j]=post[i][j];
                if(j>=1){
                    ans[i][j]+=ans[i][j-1];
                }
            }
        }
        return ans;
    }
}
