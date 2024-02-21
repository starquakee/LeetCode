public class num1901 {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] newMatrix = expandMatrix(mat);
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (isOK(mat,i,mid))return new int[]{i,mid};
                if(newMatrix[i+1][mid+1]<newMatrix[i+1][mid]){
                    right = mid-1;
                }else left = mid+1;
//                if(newMatrix[i+1][mid+1]<newMatrix[i+1][mid+2]){
//                    left = left+1;
//                }
            }
        }
        return new int[]{-1,-1};
    }

    public boolean isOK(int[][] mat, int i, int j) {
        int[][] newMatrix = expandMatrix(mat);
        return newMatrix[i + 1][j + 1] > newMatrix[i + 1][j] && newMatrix[i + 1][j + 1] > newMatrix[i + 1][j + 2] && newMatrix[i + 1][j + 1] > newMatrix[i][j + 1] && newMatrix[i + 1][j + 1] > newMatrix[i + 2][j + 1];
    }

    public static int[][] expandMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int expandedRows = m + 2;
        int expandedCols = n + 2;
        int[][] expandedMat = new int[expandedRows][expandedCols];

        // 填充新矩阵的边界为 -1
        for (int i = 0; i < expandedRows; i++) {
            for (int j = 0; j < expandedCols; j++) {
                if (i == 0 || i == expandedRows - 1 || j == 0 || j == expandedCols - 1) {
                    expandedMat[i][j] = -1;
                } else {
                    expandedMat[i][j] = mat[i - 1][j - 1];
                }
            }
        }
        return expandedMat;
    }
}
