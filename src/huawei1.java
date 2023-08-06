import java.util.*;

// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.
class node{
    int val;
    int len;
    List<node> children;
    List<node> pre;
    public node(int val){
        this.val=val;
        this.len=1;
        this.pre=new ArrayList<>();

        this.children=new ArrayList<>();
    }
}
public class huawei1 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        TreeNode left_new = invertTree(root.right);
        TreeNode right_new = invertTree(root.left);
        root.left = left_new;
        root.right = right_new;
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val==right.val){
            return check(left.left,right.right)&check(left.right,right.left);
        }
        return false;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        int ans = 0;
        if(root.val==targetSum)return 1;
        ans += rootSum(root,targetSum);
        ans += pathSum(root.left,targetSum);
        ans += pathSum(root.right,targetSum);
        return ans;
    }
    public int rootSum(TreeNode root, int targetSum){
        if(root==null)return 0;
        int ans = 0;
        if(root.val==targetSum)return 1;
        ans += rootSum(root.left,targetSum-root.val);
        ans += rootSum(root.right,targetSum-root.val);
        return ans;
    }
    public static int dfs(node nod){
        int max=0;
        Stack<node> stack = new Stack<>();
        stack.push(nod);
        String ans = "";
        int pre=0;
        boolean b = false;
        while (!stack.isEmpty()){
            if(max>99999) return -1;
            node temp = stack.pop();
            if(b){
                b=false;
                pre=temp.pre.get(0).len;
            }
            if(pre+1> temp.len){
                temp.len = pre+1;
                if(pre+1>max){
                    max=pre+1;
                }
            }
//            System.out.println(temp.val+" "+temp.len);
            pre = temp.len;
            ans += temp.val;
            for(int i=0;i<temp.children.size();i++){
                stack.push(temp.children.get(i));
            }
            if(temp.children.size()==0){
                pre=0;
                b= true;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<int[]> list = new ArrayList<>();
        node head = new node(-1);
        node[] nodes = new node[n];
        for(int i=0;i<n;i++){
            nodes[i]=new node(i+1);
        }
        for(int i=0;i<n;i++){
            int num = input.nextInt();
            node nod = nodes[i];
            if(i==0){
                head=nod;
            }
            int[] temp = new int[num];
            for(int j=0;j<num;j++){
                temp[j]=input.nextInt();
                node child = nodes[temp[j]-1];
                nod.children.add(child);
                child.pre.add(nod);
            }
            list.add(temp);
        }
        System.out.println(dfs(head));
    }
}
