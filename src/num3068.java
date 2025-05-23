public class num3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int minLoss = Integer.MAX_VALUE;
        int positiveCount = 0;

        // 计算每个节点操作后的收益
        for (int num : nums) {
            int benefit = (num ^ k) - num;
            if (benefit > 0) {
                totalSum += num ^ k;  // 操作后的值
                positiveCount++;
            } else {
                totalSum += num;      // 原始值
            }
            minLoss = Math.min(minLoss, Math.abs(benefit));
        }

        // 如果有奇数个正收益的操作，需要撤销一个最小收益的操作
        if (positiveCount % 2 == 1) {
            totalSum -= minLoss;
        }

        return totalSum;
    }
}
