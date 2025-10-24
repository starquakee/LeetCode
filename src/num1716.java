public class num1716 {
    public int totalMoney(int n) {
        int num=n/7;
        int ans=0;
        for(int i=1;i<=num;i++){
            ans+=(2*i+6)*7/2;
        }
        ans+=(num+1+num+n%7)*(n%7)/2;
        return ans;
    }
}
