public class num2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index=0,num=0;
        int m= mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1)count++;
            }
            if(count>num){
                index=i;
                num=count;
            }
        }
        return new int[]{index,num};
    }
}
