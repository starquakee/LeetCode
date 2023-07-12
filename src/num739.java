import java.util.Stack;

public class num739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<n;i++){
            int temp = temperatures[i];
            while (!stack.isEmpty()&&temp>temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        return ans;
    }
}
