public class num2040 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;
        long ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = countLessOrEqual(nums1, nums2, mid);

            if (count >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                // 如果数量 < k，说明第 k 小的值比 mid 大
                left = mid + 1;
            }
        }
        return ans;
    }

    private long countLessOrEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        // 遍历 nums1 中的每一个元素
        for (int num1 : nums1) {
            if (num1 > 0) {
                int l = 0, r = nums2.length - 1;
                int j = -1; // j 表示 nums2 中满足条件的最大下标
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) num1 * nums2[m] <= mid) {
                        j = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += (j + 1);

            } else if (num1 < 0) {
                int l = 0, r = nums2.length - 1;
                int j = nums2.length; // j 表示 nums2 中满足条件的最小下标
                while(l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) num1 * nums2[m] <= mid) {
                        j = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += (nums2.length - j);

            } else {
                if (mid >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}
