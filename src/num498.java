public class num498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        int index = 0;
        int[][] dir = {{-1,1},{1,-1}};
        int x=0,y=0;
        int d=0;
        while (index<m*n){
            ans[index] = mat[x][y];
            index++;
            int a = x+dir[d][0];
            int b = y+dir[d][1];
            if(a>=0&&a<m&&b>=0&&b<n){
                x=a;
                y=b;
            }else {
                if(d==0){
                    d=1;
                    if(b>=n){
                        x++;
                    }else if(a<0){
                        y++;
                    }
                }else {
                    d=0;
                    if(a>=m){
                        y++;
                    }else if(b<0){
                        x++;
                    }
                }
            }
        }
        return ans;
    }
}
