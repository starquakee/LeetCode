public class num2266 {
    public int countTexts(String pressedKeys) {
        long ans=1;
        long mod=1000000007;
        long[] dp3 = new long[pressedKeys.length()];
        long[] dp4 = new long[pressedKeys.length()];
        for(int i=0;i<3&&i<pressedKeys.length();i++){
            dp3[i] = (long) Math.pow(2,i);
            dp4[i] = (long) Math.pow(2,i);
        }
        if(dp4.length>=4){
            dp4[3] = 2*dp4[2];
        }
        for(int i=3;i<dp3.length;i++){
            dp3[i]=(dp3[i-3]+dp3[i-2]+dp3[i-1])%mod;
        }
        for(int i=4;i<dp4.length;i++){
            dp4[i]=(dp4[i-4]+dp4[i-3]+dp4[i-2]+dp4[i-1])%mod;
        }
        int n = pressedKeys.length();
        for(int i=0;i<n;i++){
            int cnt=1;
            while (i+1<n&&pressedKeys.charAt(i)==pressedKeys.charAt(i+1)){
                cnt++;
                i++;
            }
            if(pressedKeys.charAt(i)=='7'||pressedKeys.charAt(i)=='9'){
                ans*=dp4[cnt-1]%mod;
                ans%=mod;
            }else {
                ans*=dp3[cnt-1]%mod;
                ans%=mod;
            }

        }
        return (int) ans;
    }
}
