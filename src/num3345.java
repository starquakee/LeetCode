public class num3345 {
    public int smallestNumber(int n, int t) {
        int ans=n;
        while(ans>0){
            int product=1;
            int temp=ans;
            while(temp>0){
                product*=temp%10;
                temp/=10;
            }
            if(product%t==0)return ans;
            ans++;
        }
        return -1;
    }
}
