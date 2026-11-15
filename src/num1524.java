public class num1524 {
    public int numOfSubarrays(int[] arr) {
        int ans=0;
        int sum=0;
        int odd=0;
        int even=1;
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            sum+=num;
            if(sum%2==0){
                ans=(ans+odd)%1_000_000_007;
                even++;
            }else {
                ans=(ans+even)%1_000_000_007;
                odd++;
            }
        }
        return ans%1_000_000_007;
    }
}
