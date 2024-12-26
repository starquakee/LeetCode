import java.util.ArrayDeque;
import java.util.Queue;

public class lcr49 {
    //dfs
//    public int sumNumbers(TreeNode root) {
//        return dfs(root,0);
//    }
//    public int dfs(TreeNode root, int preSum){
//        if(root==null)return 0;
//        int sum = 10*preSum+root.val;
//        if(root.left==null&&root.right==null)return sum;
//        return dfs(root.left, sum)+dfs(root.right,sum);
//    }


    //bfs
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> numQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        int ans = 0;
        while (!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.poll();
            int sum = numQueue.poll();
            TreeNode left=temp.left, right = temp.right;
            if(left==null&&right==null){
                ans += sum;
            }else {
                if(left!=null){
                    int num = 10*sum+temp.left.val;
                    nodeQueue.offer(temp.left);
                    numQueue.offer(num);
                }
                if(right!=null){
                    int num = 10*sum+temp.right.val;
                    nodeQueue.offer(temp.right);
                    numQueue.offer(num);
                }
            }
        }
        return ans;
    }
}
