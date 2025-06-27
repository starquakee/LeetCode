import java.util.LinkedList;
import java.util.Queue;


public class BFSTree {
    // 二叉树的层序遍历（BFS）
    public void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(); // 换行表示不同层级
        }
    }

    public static void main(String[] args) {
        // 构建示例二叉树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BFSTree bfs = new BFSTree();
        System.out.println("二叉树层序遍历结果:");
        bfs.levelOrder(root);
    }
}