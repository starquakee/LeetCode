import java.util.ArrayDeque;
import java.util.Queue;

public class num1161 {
    public int maxLevelSum(TreeNode root) {
        int ans=1;
        int max = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
                sum += temp.val;
            }
            if(sum>max){
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
