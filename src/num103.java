import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class num103 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeft = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            List<TreeNode> x = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                x.add(temp);
                list.add(temp.val);
            }
            for(int i=x.size()-1;i>=0;i--){
                TreeNode temp = x.get(i);
                if(isLeft){
                    if(temp.left!=null)queue.offer(temp.left);
                    if(temp.right!=null)queue.offer(temp.right);
                }else {
                    if(temp.right!=null)queue.offer(temp.right);
                    if(temp.left!=null)queue.offer(temp.left);
                }
            }
            ans.add(list);
            isLeft = !isLeft;
        }
        return ans;
    }
}
