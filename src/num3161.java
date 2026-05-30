import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class num3161 {
    private int[] seg;

    private void update(int idx, int val, int p, int l, int r) {
        if (l == r) {
            seg[p] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) {
            update(idx, val, p << 1, l, mid);
        } else {
            update(idx, val, p << 1 | 1, mid + 1, r);
        }
        seg[p] = Math.max(seg[p << 1], seg[p << 1 | 1]);
    }

    private int query(int L, int R, int p, int l, int r) {
        if (L <= l && r <= R) {
            return seg[p];
        }
        int mid = (l + r) >> 1;
        int res = 0;
        if (L <= mid) {
            res = Math.max(res, query(L, R, p << 1, l, mid));
        }
        if (R > mid) {
            res = Math.max(res, query(L, R, p << 1 | 1, mid + 1, r));
        }
        return res;
    }

    public List<Boolean> getResults(int[][] queries) {
        int mx = 50000;
        seg = new int[mx << 2];
        TreeSet<Integer> st = new TreeSet<>();
        st.add(0);
        st.add(mx);
        update(mx, mx, 1, 0, mx);
        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                int r = Optional.ofNullable(st.ceiling(x + 1)).orElse(mx);
                int l = Optional.ofNullable(st.floor(x - 1)).orElse(0);
                update(x, x - l, 1, 0, mx);
                update(r, r - x, 1, 0, mx);
                st.add(x);
            } else {
                int x = q[1];
                int sz = q[2];
                int pre = Optional.ofNullable(st.floor(x)).orElse(0);
                int max_space = query(0, pre, 1, 0, mx);
                max_space = Math.max(max_space, x - pre);
                ans.add(max_space >= sz);
            }
        }
        return ans;
    }
}
