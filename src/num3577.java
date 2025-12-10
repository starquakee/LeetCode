public class num3577 {
    public int countPermutations(int[] complexity) {
        long ans=1L;
        int MOD= (int) (1e9+7);
        int preMin=complexity[0];
        int n=complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i]<=preMin){
                return 0;
            }
        }
        for(int i=2;i<=n-1;i++){
            ans=(ans*i)%MOD;
        }
        return (int)ans;
    }
}
