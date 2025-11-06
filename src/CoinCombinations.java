import java.util.*;

public class CoinCombinations {

    // 使用 TreeMap 来存储结果，它会根据 Key（金额）自动排序
    // Key: 总金额
    // Value: 构成该金额的所有组合方式的列表
    private Map<Integer, List<List<Integer>>> results;
    private int[] denominations; // 存储面额

    /**
     * 主函数，用于启动计算并打印结果
     */
    public void findAllCombinations(int[] denominations) {
        this.denominations = denominations;
        this.results = new TreeMap<>();

        // 开始递归搜索
        // 初始参数：从第0个面额开始，当前总和为0，当前路径（组合）为空
        backtrack(0, 0, new ArrayList<>());

        // 打印所有结果
        printResults();
    }

    /**
     * 递归回溯函数
     * @param index 当前正在考虑的面额索引 (对应 denominations 数组)
     * @param currentSum 当前组合的总金额
     * @param currentPath 当前组合的路径（包含哪些钱币）
     */
    private void backtrack(int index, int currentSum, List<Integer> currentPath) {
        // --- 基础情况 (Base Case) ---
        // 如果已经考虑完了所有面额
        if (index == denominations.length) {
            // 我们不存储总和为 0 的情况
            if (currentSum > 0) {
                // putIfAbsent 确保如果 Map 中还没有这个 key，就创建一个新的 ArrayList
                results.putIfAbsent(currentSum, new ArrayList<>());

                // **重要**: 必须添加 currentPath 的一个新副本 (copy)
                // 否则后续的回溯操作会修改已经存入 map 的 List
                results.get(currentSum).add(new ArrayList<>(currentPath));
            }
            return; // 结束当前递归分支
        }

        // --- 递归步骤 (Recursive Step) ---

        int currentDenomination = denominations[index];

        // 1. 选择 0 个当前面额
        backtrack(index + 1, currentSum, currentPath);

        // 2. 选择 1 个当前面额
        currentPath.add(currentDenomination); // "拿"
        backtrack(index + 1, currentSum + currentDenomination, currentPath);
        currentPath.remove(currentPath.size() - 1); // 回溯: "放回去"

        // 3. 选择 2 个当前面额
        currentPath.add(currentDenomination); // "拿" 第 1 个
        currentPath.add(currentDenomination); // "拿" 第 2 个
        backtrack(index + 1, currentSum + (currentDenomination * 2), currentPath);
        currentPath.remove(currentPath.size() - 1); // 回溯: "放回去" 第 2 个
        currentPath.remove(currentPath.size() - 1); // 回溯: "放回去" 第 1 个
    }

    /**
     * 格式化打印 Map 中的所有结果
     */
    private void printResults() {
        if (results.isEmpty()) {
            System.out.println("没有找到任何组合。");
            return;
        }

        System.out.println("所有可支付的金额及其方式如下：");
        for (Map.Entry<Integer, List<List<Integer>>> entry : results.entrySet()) {
            int sum = entry.getKey();
            List<List<Integer>> combinations = entry.getValue();

            System.out.println("--- 金额: " + sum + " ---");
            for (List<Integer> combo : combinations) {
                System.out.println("  > " + combo);
            }
        }
    }

    /**
     * Main 方法用于测试
     */
    public static void main(String[] args) {
        CoinCombinations solver = new CoinCombinations();

        // 示例1: 只有 {1, 1} 和 {2, 2}
        int[] denominationsSmall = {1, 2};
        System.out.println("====== 测试 {1, 2} (每种两个) ======");
        solver.findAllCombinations(denominationsSmall);
        System.out.println("\n");

        // 示例2: {1, 1}, {2, 2}, {4, 4} ... {16, 16}
        int[] denominationsLarge = {1, 2, 4, 8, 16};
        System.out.println("====== 测试 {1, 2, 4, 8, 16} (每种两个) ======");
        solver.findAllCombinations(denominationsLarge);
    }
}