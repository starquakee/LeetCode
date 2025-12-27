import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class num2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> availRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availRooms.offer(i);
        }
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        int[] usedCount = new int[n];
        long curTime = 0;
        for (int[] meeting : meetings) {
            curTime = Math.max(curTime, meeting[0]);
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= curTime) {
                availRooms.offer((int)usedRooms.poll()[1]);
            }
            if (availRooms.isEmpty()) {
                curTime = usedRooms.peek()[0];
                while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= curTime) {
                    availRooms.offer((int)usedRooms.poll()[1]);
                }
            }
            int room = availRooms.poll();
            usedCount[room]++;
            usedRooms.offer(new long[]{curTime + meeting[1] - meeting[0], room});
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (usedCount[i] > usedCount[ans]) ans = i;
        }
        return ans;
    }
}
