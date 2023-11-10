import java.util.Arrays;

public class num2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] arr = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            arr[i] = binarySearch(spells[i],potions,success);
        }
        return arr;
    }
    public int binarySearch(int spell,int[] positions,long success){
        int m = positions.length;
        int left=0;
        int right=m-1;
        int mid;
        int ans = m;
        while (left<=right){
            mid = (left+right)/2;
            long ji = (long)( (long) spell*(long) positions[mid]);
            if(ji<success){
                left = mid +1;
            }else if(ji>success){
                ans =mid;
                right = mid-1;
            }else return m-mid;
        }
        return m-ans;
    }
}
