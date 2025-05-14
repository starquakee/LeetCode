import java.util.List;

public class num3337 {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int MOD=1_000_000_007;
        int[] cnt = new int[26];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i=0;i<t;i++){
            int[] temp = new int[26];
            for(int j=0;j<26;j++){
                int nextLen=nums.get(j);
                for(int k=1;k<=nextLen;k++){
                    temp[(j+k)%26] = (temp[(j+k)%26]+cnt[j])%MOD;
                }
            }
            cnt=temp;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans = (ans+cnt[i])%MOD;
        }
        return ans;
    }
}
