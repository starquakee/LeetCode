import java.util.HashSet;
import java.util.Set;

public class num73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> hang = new HashSet<>();
        Set<Integer> lie = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    hang.add(i);
                    lie.add(j);
                }
            }
        }
        for(Integer i:hang){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }
        for(Integer i:lie){
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }
    }
}
