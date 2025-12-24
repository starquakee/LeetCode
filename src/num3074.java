import java.util.Arrays;

public class num3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int a:apple)sum+=a;
        Arrays.sort(capacity);
        for(int i=capacity.length-1;i>=0;i--){
            sum-=capacity[i];
            if(sum<=0)return capacity.length-i;
        }
        return -1;
    }
}
