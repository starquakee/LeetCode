import java.util.Objects;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class num100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        String a = dfs(p);
        String b = dfs(q);
        System.out.println(a+" "+b);

        if(p==null&&q==null){
            return true;
        }else if(p!=null&&q!=null){
            return p.val == q.val &&isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }else return false;
    }
    public static String dfs(TreeNode treeNode){
        String ans = "";
        if(treeNode==null)return "0";
        ans+=dfs(treeNode.left);
        ans+=treeNode.val;
        ans+=dfs(treeNode.right);
        return ans;
    }
//    public static String dfs(TreeNode treeNode){
//        String ans="";
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(treeNode);
//        while (!stack.isEmpty()){
//            TreeNode temp = stack.pop();
//            if(temp.right!=null){
//                stack.push(temp.right);
//            }
//            if(temp.left!=null){
//                stack.push(temp.left);
//            }
//
//            ans += temp.val;
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(2);
        TreeNode b1=new TreeNode(1);
        TreeNode b2=new TreeNode(2);
        TreeNode a=a1;
        a.left=a2;
        TreeNode b=b1;
        b.right=b2;
        System.out.println(isSameTree(a,b));

    }
}
