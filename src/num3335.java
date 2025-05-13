public class num3335 {
    public int lengthAfterTransformations(String s, int t) {
        int MOD=1_000_000_007;
        int[] cnt = new int[26];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i=0;i<t;i++){
            int[] temp = new int[26];
            temp[0]=cnt[25];
            temp[1]=(cnt[0]+cnt[25])%MOD;
            System.arraycopy(cnt, 1, temp, 2, 24);
            cnt=temp;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans = (ans+cnt[i])%MOD;
        }
        return ans;
    }
}
