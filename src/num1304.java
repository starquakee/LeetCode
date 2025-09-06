public class num1304 {
    public int[] sumZero(int n) {
        int[] ans=new int[n];
        if(n%2==1){
            for(int i=0;i<n;i++){
                ans[i]=-n/2+i;
            }
        }else {
            for(int i=0;i<n/2;i++){
                ans[i]=i+1;
            }
            for(int i=n/2;i<n;i++){
                ans[i]=i-n;
            }
        }
        return ans;
    }
}
