import java.util.*;

public class num2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Long> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                sum += temp.val;
            }
            list.add(sum);
        }
        Collections.sort(list);
        if(list.size()<k)return -1;
        return list.get(list.size()-k);
    }
}
