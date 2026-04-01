import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class num2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(positions[a], positions[b]));
        Stack<int[]> stack = new Stack<>();

        for (int i : idx) {
            int curIdx = i;
            int curHp = healths[i];
            char curDir = directions.charAt(i);

            while (!stack.isEmpty()) {
                int[] prev = stack.peek();
                char prevDir = (char)prev[2];

                if (prevDir == 'R' && curDir == 'L') {
                    stack.pop();
                    if (prev[1] > curHp) {
                        curIdx = prev[0];
                        curHp = prev[1] - 1;
                        curDir = prevDir;
                    } else if (prev[1] < curHp) {
                        curHp -= 1;
                    } else {
                        curIdx = -1;
                        break;
                    }
                } else {
                    break;
                }
            }

            if (curIdx != -1) {
                stack.push(new int[]{curIdx, curHp, curDir});
            }
        }

        List<int[]> alive = new ArrayList<>(stack);
        alive.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> ans = new ArrayList<>();
        for (int[] robot : alive) {
            ans.add(robot[1]);
        }
        return ans;
    }
}
