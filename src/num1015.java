public class num1015 {
    public int smallestRepunitDivByK(int k) {
        int temp=1;
        int ans=1;
        while (temp%k!=0){
            temp=(temp*10+1)%k;
            ans++;
            if(ans>k+100)return -1;
        }
        return ans;
    }
}
