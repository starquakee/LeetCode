import java.util.Arrays;

public class num960 {
    public int minDeletionSize(String[] strs) {
        int l=strs[0].length();
        int[] dp = new int[l];
        Arrays.fill(dp,1);
        for(int i=l-2;i>=0;i--){
            for(int j=i+1;j<l;j++){
                boolean skip=false;
                for(String str:strs){
                    if(str.charAt(i)>str.charAt(j)){
                        skip=true;
                        break;
                    }
                }
                if(skip)continue;
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int max=0;
        for(int i=0;i<l;i++){
            max=Math.max(max,dp[i]);
        }
        return l-max;
    }
}
