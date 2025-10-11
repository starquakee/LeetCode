import java.util.*;

public class num3186 {
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int p : power) {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{-1000000000,0});
        for (Map.Entry<Integer,Integer> e : count.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int n = list.size();
        long[] f = new long[n];
        long max = 0, ans = 0;
        int j = 1;
        for (int i = 1; i < n; i++) {
            while (j < i && list.get(j)[0] < list.get(i)[0] - 2) {
                max = Math.max(max, f[j]);
                j++;
            }
            f[i] = max + 1L * list.get(i)[0] * list.get(i)[1];
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
