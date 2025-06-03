import java.util.ArrayDeque;
import java.util.Queue;

public class num1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            canOpen[i] = (status[i] == 1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int ans = 0;
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                queue.offer(box);
                used[box] = true;
                ans += candies[box];
            }
        }
        while (!queue.isEmpty()){
            int box= queue.poll();
            for(int key:keys[box]){
                canOpen[key]=true;
            }
            for(int newBox:containedBoxes[box]){
                hasBox[newBox]=true;
            }
            for(int i=0;i<n;i++){
                if(hasBox[i]&&canOpen[i]&&!used[i]){
                    queue.offer(i);
                    used[i]=true;
                    ans += candies[i];
                }
            }
        }
        return ans;
    }
}
