public class num3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int ans=1;
        while (ans<=n) {
            ans*=2;
        }
        return ans;
    }
}
