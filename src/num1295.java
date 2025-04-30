public class num1295 {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(Integer num:nums){
            if(String.valueOf(num).length()%2==0)ans++;
        }
        return ans;
    }
}
