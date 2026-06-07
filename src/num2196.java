import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> parent = new HashSet<>();
        Set<Integer> child = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            if(!map.containsKey(description[0])) {
                map.put(description[0], new TreeNode(description[0]));
            }
            if(!map.containsKey(description[1])) {
                map.put(description[1], new TreeNode(description[1]));
            }
            parent.add(description[0]);
            child.add(description[1]);
            TreeNode p = map.get(description[0]);
            TreeNode c = map.get(description[1]);
            if (description[2] == 1) {
                p.left = c;
            } else {
                p.right = c;
            }
        }
        for(Integer node:parent) {
            if (!child.contains(node)) {
                return map.get(node);
            }
        }
        return null;
    }
}
