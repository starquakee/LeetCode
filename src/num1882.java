import java.util.PriorityQueue;

public class num1882 {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // 工作中的服务器，存储二元组 (t, idx)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 空闲的服务器，存储二元组 (w, idx)
        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[]{servers[i], i});
        }

        int ts = 0;
        int[] ans = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            ts = Math.max(ts, i);
            release(busy, idle, servers, ts);
            if (idle.isEmpty()) {
                ts = busy.peek()[0];
                release(busy, idle, servers, ts);
            }

            int[] server = idle.poll();
            int idx = server[1];
            ans[i] = idx;
            busy.offer(new int[]{ts + tasks[i], idx});
        }

        return ans;
    }

    // 将优先队列 busy 中满足 t<=ts 依次取出并放入优先队列 idle
    private void release(PriorityQueue<int[]> busy, PriorityQueue<int[]> idle,
                         int[] servers, int ts) {
        while (!busy.isEmpty() && busy.peek()[0] <= ts) {
            int[] server = busy.poll();
            int idx = server[1];
            idle.offer(new int[]{servers[idx], idx});
        }
    }
}
