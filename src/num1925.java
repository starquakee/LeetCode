public class num1925 {
    public int countTriples(int n) {
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                int k=(int)Math.sqrt(i*i+j*j);
                if(k<=n&&i*i+j*j==k*k) ans++;
            }
        }
        return ans;
    }
}
