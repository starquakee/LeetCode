public class num66 {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        boolean isAllNine=true;
        for(int digit:digits){
            if(digit!=9)isAllNine=false;
        }
        if(isAllNine){
            int[] ans=new int[n+1];
            ans[0]=1;
            return ans;
        }
        int[] ans=new int[n];
        int carry=1;
        for(int i=n-1;i>=0;i--){
            int temp=carry+digits[i];
            carry=temp/10;
            ans[i]=temp%10;
        }
        return ans;
    }
}
