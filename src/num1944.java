import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class num1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while (!deque.isEmpty()){
                ans[i]++;
                if(heights[i]<=deque.peek()){
                    break;
                }
                deque.pop();
            }
            deque.push(heights[i]);
        }
        return ans;
    }
}
