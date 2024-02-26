import java.util.*;

public class num2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
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
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            List<Integer> x = new ArrayList<>();
            int index = Collections.binarySearch(list, queries.get(i));
            if(index>=0){
                x.add(list.get(index));
                x.add(list.get(index));
            }else {
                int insertPoint = -index - 1;
                // 比目标数小的最大数
                int smallerClosest = insertPoint - 1 >= 0 ? list.get(insertPoint - 1) : -1;
                // 比目标数大的最小数
                int largerClosest = insertPoint < list.size() ? list.get(insertPoint) : -1;
                x.add(smallerClosest);
                x.add(largerClosest);
            }
            ans.add(x);
        }
        return ans;
    }
}
