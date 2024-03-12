import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class FindElements {
    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            set.add(temp.val);
            if(temp.left!=null){
                temp.left.val = 2*temp.val+1;
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                temp.right.val = 2*temp.val+2;
                queue.offer(temp.right);
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
