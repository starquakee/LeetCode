import java.util.*;

public class num938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);
            list.add(temp.val);

        }
        Collections.sort(list);
        int index_begin = Collections.binarySearch(list, low);
        int index_end = Collections.binarySearch(list, high);
        int ans = 0;
        for(int i=index_begin;i<=index_end;i++){
            ans += list.get(i);
        }
        return ans;
    }
}
