import java.util.Arrays;

public class num2931 {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;
        int[] arr = new int[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i*m+j] = values[i][j];
            }
        }
        Arrays.sort(arr);
        long ans = 0;
        for(int i=0;i<n*m;i++){
            ans += (long) arr[i] *(i+1);
        }
        return ans;
    }
}
