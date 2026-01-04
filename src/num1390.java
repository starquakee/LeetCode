public class num1390 {
    int ans=0;
    public int sumFourDivisors(int[] nums) {
        for(int num:nums){
            check(num);
        }
        return ans;
    }
    public boolean check(int num){
        int count=0;
        int temp=0;
        for(int i=1;i<Math.sqrt(num);i++){
            if(num%i==0){
                count+=2;
                temp+=i+num/i;
            }
        }
        if(Math.sqrt(num)==(int)Math.sqrt(num))return false;
        if(count==4){
            ans+=temp;
        }
        return count==4;
    }
}
