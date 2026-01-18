public class num1895 {
    public int largestMagicSquare(int[][] grid) {
        int ans=1;
        int m=grid.length;
        int n=grid[0].length;
        int[][] rowSum=new int[grid.length+1][grid[0].length+1];
        int[][] colSum=new int[grid.length+1][grid[0].length+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                rowSum[i][j]=rowSum[i][j-1]+grid[i-1][j-1];
                colSum[i][j]=colSum[i-1][j]+grid[i-1][j-1];
            }
        }
        int s=Math.min(m,n);
        for(int i=s;i>=2;i--){
            for(int j=0;j<m-i+1;j++){
                for(int k=0;k<n-i+1;k++){
                    boolean check=true;
                    int sum=rowSum[j+1][k+i]-rowSum[j+1][k];
                    for(int l=j;l<j+i;l++){
                        if(sum!=rowSum[l+1][k+i]-rowSum[l+1][k]){
                            check=false;
                            break;
                        }
                    }
                    if(check){
                        for(int l=k;l<k+i;l++){
                            if(sum!=colSum[j+i][l+1]-colSum[j][l+1]){
                                check=false;
                                break;
                            }
                        }
                    }
                    if(check){
                        int temp=0;
                        for(int l=j;l<j+i;l++){
                            temp+=grid[l][l+k-j];
                        }
                        if(temp!=sum)check=false;
                    }
                    if(check){
                        int temp=0;
                        for(int l=j;l<j+i;l++){
                            temp+=grid[l][k+i-1-(l-j)];
                        }
                        if(temp!=sum)check=false;
                    }
                    if(check)return i;
                }
            }
        }
        return ans;
    }
}
