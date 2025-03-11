public class num2269 {
    public int divisorSubstrings(int num, int k) {
        int ans=0;
        String n=String.valueOf(num);
        for(int i=0;i<n.length()+1-k;i++){
            int temp=Integer.parseInt(n.substring(i,i+k));
            if(temp!=0&&num%temp==0)ans++;
        }
        return ans;
    }
}
