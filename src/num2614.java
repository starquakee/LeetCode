public class num2614 {
    public int diagonalPrime(int[][] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int j=n-i-1;
            if(nums[i][i]>ans&&isPrime(nums[i][i]))ans=nums[i][i];
            if(nums[i][j]>ans&&isPrime(nums[i][j]))ans=nums[i][j];
        }
        return ans;
    }
    public boolean isPrime(int num){
        if(num<2)return false;
        if(num==2)return true;
        if(num%2==0)return false;
        for(int i=3;i*i<=num;i+=2){
            if(num%i==0)return false;
        }
        return true;
    }
}
