public class num238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] tail = new int[n];
        pre[0] = nums[0];
        tail[n-1] = nums[n-1];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]*nums[i];
        }
        for(int i=n-2;i>=0;i--){
            tail[i]=tail[i+1]*nums[i];
        }
        for(int i=0;i<n;i++){
            if(i>0&&i<n-1){
                ans[i] = pre[i-1]*tail[i+1];
            }else if(i==0){
                ans[i] = tail[1];
            }else if(i==n-1){
                ans[i] = pre[n-2];
            }
        }
        return ans;
    }
}
