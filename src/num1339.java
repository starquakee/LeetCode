public class num1339 {
    long mid=0;
    public int maxProduct(TreeNode root) {
        long minDiff=Long.MAX_VALUE;
        int MOD=(int)1e9+7;
        long sum=sum(root);
        sum1(root,sum);
        mid = mid%MOD;
        sum = sum%MOD;
        return (int) (mid*(sum-mid)%MOD);
    }
    public long sum(TreeNode root){
        if(root==null)return 0L;
        long l=sum(root.left);
        long r=sum(root.right);
        return root.val+l+r;
    }
    public long sum1(TreeNode root,long sum){
        if(root==null)return 0L;
        long l=sum1(root.left,sum);
        long r=sum1(root.right,sum);
        long temp=root.val+l+r;
        if(Math.abs(sum/2-temp)<Math.abs(sum/2-mid))mid=temp;
        return temp;
    }
}
