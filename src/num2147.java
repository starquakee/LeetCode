public class num2147 {
    public int numberOfWays(String corridor) {
        long ans=1L;
        int MOD = (int) (1e9 + 7);
        int n=corridor.length();
        char[] arr = corridor.toCharArray();
        int all=0;
        for(char c:arr){
            if(c=='S')all++;
        }
        if(all%2==1||all==0)return 0;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]=='S')count++;
            if(count>=2&&count%2==0&&count<all){
                i++;
                int temp=1;
                while (i<n&&arr[i]=='P'){
                    temp++;
                    i++;
                }
                i--;
                ans=(ans*temp)%MOD;
            }
        }
        return (int)ans;
    }
}
