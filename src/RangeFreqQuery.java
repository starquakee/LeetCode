import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(arr[i], newList);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        int l = 0, r = list.size() - 1;
        int lIndex, rIndex;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (list.get(mid) >= left) {
                r = mid - 1;
            } else if (list.get(mid) < left) {
                l = mid + 1;
            }
        }
        lIndex = l;
        l = 0;
        r = list.size() - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (list.get(mid) > right) {
                r = mid - 1;
            } else if (list.get(mid) <= right) {
                l = mid + 1;
            }
        }
        rIndex = l;
        return rIndex - lIndex;
    }
}
