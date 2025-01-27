import java.util.Arrays;

public class num45 {
//    public int jump(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        int place = 0;
//        while (place<n-1){
//            int max_len = 0;
//            int next_place = 0;
//            for(int j=1;j<=nums[place];j++){
//                if(place+j>=n-1) return ans+1;
//                if(nums[place+j]+place+j>max_len){
//                    max_len = nums[place+j]+place+j;
//                    next_place = place+j;
//                }
//            }
//            ans++;
//            place = next_place;
//        }
//        return ans;
//    }
//    public int jump(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        Arrays.fill(ans,Integer.MAX_VALUE);
//        ans[0]=0;
//        for(int i=0;i<n;i++){
//            for(int j=1;j<=nums[i]&&i+j<n;j++){
//                ans[i+j]=Math.min(ans[i+j],ans[i]+1);
//            }
//        }
//        return ans[n-1];
//    }
    // ans is monotonically increasing
    public int jump(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int updating = 0;
        for(int i=0;i<n;i++){
            int j=updating+1-i;
            for(;j<=nums[i]&&i+j<n;j++){
                ans[i+j]=ans[i]+1;
            }
            updating=i+j-1;
            System.out.println(updating);
            if (updating==n-1)break;
        }
        System.out.println(Arrays.toString(ans));
        return ans[n-1];
    }
}
