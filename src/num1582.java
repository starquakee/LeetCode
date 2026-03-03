public class num1582 {
    public int numSpecial(int[][] mat) {
        int ans=0;
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
            if(sum==1){
                for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]==1){
                        int sum2=0;
                        for(int k=0;k<mat.length;k++){
                            sum2+=mat[k][j];
                        }
                        if(sum2==1)ans++;
                    }
                }
            }
        }
        return ans;
    }
}
