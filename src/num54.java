import java.util.ArrayList;
import java.util.List;

public class num54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int row = 0;
        int column = 0;
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[row][column]);
            visited[row][column]=true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n|| visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];

        }
        return list;
    }
}
