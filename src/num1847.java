import java.util.*;

class Event implements Comparable<Event> {
    int type, size, id, origin;

    public Event(int type, int size, int id, int origin) {
        this.type = type;
        this.size = size;
        this.id = id;
        this.origin = origin;
    }

    @Override
    public int compareTo(Event that) {
        // 自定义比较函数，按照事件的 size 降序排序
        // 如果 size 相同，优先考虑房间事件
        if (this.size != that.size) {
            return Integer.compare(that.size, this.size);
        } else {
            return Integer.compare(this.type, that.type);
        }
    }
}
public class num1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int m = rooms.length;
        int n = queries.length;

        // 创建事件列表，存储房间和询问事件
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            // 房间事件
            events.add(new Event(0, rooms[i][1], rooms[i][0], i));
        }
        for (int i = 0; i < n; ++i) {
            // 询问事件
            events.add(new Event(1, queries[i][1], queries[i][0], i));
        }
        // 对事件列表进行排序
        Collections.sort(events);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 使用 TreeSet 存储房间 roomId 的有序集合，用来查找最近的房间
        TreeSet<Integer> valid = new TreeSet<>();

        for (Event event : events) {
            if (event.type == 0) {
                // 房间事件，将 roomId 加入有序集合
                valid.add(event.id);
            } else {
                // 询问事件，查找最近的房间
                Integer higher = valid.ceiling(event.id);
                Integer lower = valid.floor(event.id);
                int dist = Integer.MAX_VALUE;

                // 查找最小的大于等于 preferred 的元素
                if (higher != null && higher - event.id < dist) {
                    dist = higher - event.id;
                    ans[event.origin] = higher;
                }
                // 查找最大的严格小于 preferred 的元素
                if (lower != null && event.id - lower <= dist) {
                    ans[event.origin] = lower;
                }
            }
        }

        return ans;
    }
}
