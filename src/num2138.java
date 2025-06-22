public class num2138 {
    public String[] divideString(String s, int k, char fill) {
        int num=(s.length()+k-1)/k;
        String[] ans = new String[num];
        for(int i=0;i<num-1;i++){
            ans[i]=s.substring(i*k,i*k+k);
        }
        ans[num-1]=s.substring((num-1)*k);
        while (ans[num-1].length()<k){
            ans[num-1]=ans[num-1]+fill;
        }
        return ans;
    }
}
