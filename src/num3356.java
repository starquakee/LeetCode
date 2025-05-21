public class num3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = queries.length;
        int l = 0;
        int r = queries.length - 1;
        if (!check(nums, queries, queries.length)) return -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(nums, queries, mid)) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    public boolean check(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diffArray = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int[] query = queries[i];
            diffArray[query[0]] += query[2];
            diffArray[query[1] + 1] -= query[2];
        }
        int[] preSum = new int[n];
        preSum[0] = diffArray[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + diffArray[i];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - preSum[i] > 0) return false;
        }
        return true;
    }
}
