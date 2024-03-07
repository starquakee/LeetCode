public class num2575 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long[] yu = new long[n];
        int[] ans = new int[n];
        yu[0] = (word.charAt(0)-'0')%m;
        if(yu[0]==0)ans[0] = 1;
        for(int i=1;i<n;i++){
            yu[i] = ((10*yu[i-1])%m+(word.charAt(i)-'0')%m)%m;
            if(yu[i]==0)ans[i] = 1;
        }
        return ans;
    }
}
