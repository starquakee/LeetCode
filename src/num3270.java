public class num3270 {
    public int generateKey(int num1, int num2, int num3) {
        int ans=0;
        for(int i=0;i<4;i++){
            int temp1=num1%10;
            int temp2=num2%10;
            int temp3=num3%10;
            int min=Math.min(temp1,temp2);
            min = Math.min(min,temp3);
            ans+= (int) (min*Math.pow(10,i));
            num1/=10;
            num2/=10;
            num3/=10;
        }
        return ans;
    }
}
