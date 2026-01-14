import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class SegmentTree {
    private int[] count;
    private int[] covered;
    private int[] xs;
    private int n;

    public SegmentTree(int[] xs_) {
        xs = xs_;
        n = xs.length - 1;
        count = new int[4 * n];
        covered = new int[4 * n];
    }

    private void modify(int qleft, int qright, int qval, int left, int right, int pos) {
        if (xs[right + 1] <= qleft || xs[left] >= qright) {
            return;
        }
        if (qleft <= xs[left] && xs[right + 1] <= qright) {
            count[pos] += qval;
        } else {
            int mid = (left + right) / 2;
            modify(qleft, qright, qval, left, mid, pos * 2 + 1);
            modify(qleft, qright, qval, mid + 1, right, pos * 2 + 2);
        }

        if (count[pos] > 0) {
            covered[pos] = xs[right + 1] - xs[left];
        } else {
            if (left == right) {
                covered[pos] = 0;
            } else {
                covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
            }
        }
    }

    public void update(int qleft, int qright, int qval) {
        modify(qleft, qright, qval, 0, n - 1, 0);
    }

    public int query() {
        return covered[0];
    }
}
public class num3454 {
    public double separateSquares(int[][] squares) {
        // 存储事件: (y坐标, 类型, 左边界, 右边界)
        List<int[]> events = new ArrayList<>();
        Set<Integer> xsSet = new TreeSet<>();

        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];
            int xr = x + l;
            events.add(new int[]{y, 1, x, xr});
            events.add(new int[]{y + l, -1, x, xr});
            xsSet.add(x);
            xsSet.add(xr);
        }

        // 按y坐标排序事件
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        // 离散化坐标
        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        // 初始化线段树
        SegmentTree segTree = new SegmentTree(xs);

        List<Long> psum = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();
        Long totalArea = 0L;
        int prev = events.get(0)[0];

        // 扫描：计算总面积和记录中间状态
        for (int[] event : events) {
            int y = event[0], delta = event[1], xl = event[2], xr = event[3];
            int len = segTree.query();
            totalArea += (long) len * (y - prev);
            segTree.update(xl, xr, delta);
            // 记录前缀和和宽度
            psum.add(totalArea);
            widths.add(segTree.query());
            prev = y;
        }

        // 计算目标面积（向上取整的一半）
        long target = (long)(totalArea + 1) / 2;
        // 二分查找
        int i = binarySearch(psum, target);
        double area = psum.get(i);
        // 获取对应的面积、宽度和高度
        int width = widths.get(i), height = events.get(i)[0];

        return height + (totalArea - area * 2) / (width * 2.0);
    }

    private int binarySearch(List<Long> list, long target) {
        int left = 0;
        int right = list.size() - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
