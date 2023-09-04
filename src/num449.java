import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class num449 {
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null)return ans.toString();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                ans.append(String.valueOf(temp.val)).append(",");
                if (temp.left == null && temp.right != null) {
                    queue.offer(new TreeNode(998999));
                    queue.offer(temp.right);
                } else if (temp.left == null && temp.right == null) {
                    if(!queue.isEmpty()){
                        if(queue.peek().left!=null||queue.peek().right!=null){
                            queue.offer(new TreeNode(998999));
                            queue.offer(new TreeNode(998999));
                        }
                    }
                } else {
                    if(temp.left!=null)queue.offer(temp.left);
                    if(temp.right!=null)queue.offer(temp.right);
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(!data.contains(","))return null;
        String[] strings = data.split(",");
        int num = strings.length;
        System.out.println(num);
        TreeNode[] treeNodes = new TreeNode[num];
        for(int i=0;i<num;i++){
            treeNodes[i] = new TreeNode(Integer.parseInt(strings[i]));
            if(Objects.equals(strings[i], "998999"))treeNodes[i]=null;
        }
        for(int i=0;i<=(num-2)/2;i++){
            if(i*2+1<num){
                if(treeNodes[i]!=null)treeNodes[i].left = treeNodes[i*2+1];
            }
            if(i*2+2<num){
                if(treeNodes[i]!=null)treeNodes[i].right = treeNodes[i*2+2];
            }
        }
        return treeNodes[0];
    }
}
