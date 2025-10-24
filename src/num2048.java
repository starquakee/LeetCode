public class num2048 {
    public int nextBeautifulNumber(int n) {
        int ans=n+1;
        while (true){
            if(checkNumber(ans)){
                return ans;
            }
            ans++;
        }
    }
    public boolean checkNumber(int n) {
        int[] freq = new int[10];
        while (n>=1) {
            freq[n % 10]++;
            n /= 10;
        }
        for(int j=0;j<freq.length;j++){
            if(freq[j]!=0&&freq[j]!=j){
                return false;
            }
        }
        return true;
    }
}
