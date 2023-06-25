public class num48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        for(int i=n-1;i>=0;i--){
            for (int j = 0; j < n; j++) {
                matrix[n-1-i][j] = copy[n-1-j][n-1-i];
            }
        }
    }
}
