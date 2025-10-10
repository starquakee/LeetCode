public class num3147 {
    public int maximumEnergy(int[] energy, int k) {
        int ans=Integer.MIN_VALUE;
        int[] preSum=new int[energy.length];
        int[] sum=new int[k];
        for(int i=0;i<k;i++){
            for(int j=i;j<energy.length;j+=k){
                if(j>i){
                    preSum[j]=preSum[j-k]+energy[j-k];
                }
                sum[i]+=energy[j];
            }
        }
        for(int i=0;i<k;i++){
            for(int j=i;j<energy.length;j+=k){
                ans=Math.max(ans,sum[i]-preSum[j]);
            }
        }
        return ans;
    }
}
