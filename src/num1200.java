import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i+1]-arr[i]<=min){
                if(arr[i+1]-arr[i]<min){
                    min = arr[i+1]-arr[i];
                    ans.clear();
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
