public class num74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while (satisfy(matrix,i,j)){
            if(matrix[i][j]<target){
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }else return true;
        }
        return false;
    }
    public boolean satisfy(int[][] matrix,int i,int j){
        int m = matrix.length;
        int n = matrix[0].length;
        return i < m && i >= 0 && j < n && j >= 0;
    }
}
