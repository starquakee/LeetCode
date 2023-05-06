import java.util.ArrayList;
import java.util.List;

public class num113 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return targetSum==root.val;
        } else if (root.left != null && root.right != null) {
            return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
        } else if (root.left == null) {
            return hasPathSum(root.right,targetSum-root.val);
        } else {
            return hasPathSum(root.left,targetSum- root.val);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans_final = new ArrayList<>();
        if(root==null){
            return ans;
        }
        if(root.left==null&&root.right==null){
            if(targetSum==root.val){
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                ans_final.add(temp);
                return ans_final;
            }
        }else if (root.left != null && root.right != null){
            if(hasPathSum(root.left,targetSum-root.val)){
                ans = pathSum(root.left,targetSum-root.val);
                for (List<Integer> an : ans) {
                    an.add(0, root.val);
                    ans_final.add(an);
                }
            }
            if(hasPathSum(root.right,targetSum-root.val)){
                ans = pathSum(root.right,targetSum-root.val);
                for (List<Integer> an : ans) {
                    an.add(0, root.val);
                    ans_final.add(an);
                }
            }
            return ans_final;
        } else if (root.left == null) {
            if(hasPathSum(root.right,targetSum-root.val)){
                ans = pathSum(root.right,targetSum-root.val);
                for (List<Integer> an : ans) {
                    an.add(0, root.val);
                    ans_final.add(an);
                }
            }
            return ans_final;
        }else {
            if(hasPathSum(root.left,targetSum-root.val)){
                ans = pathSum(root.left,targetSum-root.val);
                for (List<Integer> an : ans) {
                    an.add(0, root.val);
                    ans_final.add(an);
                }
            }
            return ans_final;
        }
        return ans_final;
    }
    public static void main(String[] args) {

    }
}
