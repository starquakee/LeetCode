public class num1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(check(mat,target))return true;
            mat=rotate(mat);
        }
        return false;
    }
    public int[][] rotate(int[][] mat){
        int m=mat.length,n=mat[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[j][m-1-i]=mat[i][j];
            }
        }
        return ans;
    }
    public boolean check(int[][] mat,int[][] target){
        int m=mat.length,n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }
}
