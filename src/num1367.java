public class num1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        String s = "";
        while (head!=null){
            s = s+head.val;
            head = head.next;
        }
        String pres = "";
        return dfs(root.left,pres+root.val,s)||dfs(root.right,pres+root.val,s);

    }
    public boolean dfs(TreeNode root,String pres,String s){
        if(root==null){
            return pres.contains(s);
        }
        return dfs(root.left,pres+root.val,s)||dfs(root.right,pres+root.val,s);
    }
}
