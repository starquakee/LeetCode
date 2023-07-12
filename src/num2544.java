public class num2544 {
    public int alternateDigitSum(int n) {
        String num = String.valueOf(n);
        int ans=0;
        for(int i=0;i<num.length();i++){
            int temp = num.charAt(i)-'0';
            if(i%2==0){
                ans+=temp;
            }else ans-=temp;
        }
        return ans;
    }
}
