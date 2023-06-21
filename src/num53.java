import java.util.Queue;

public class num53 {
    public int maxSubArray(int[] nums) {
//        int[] a = new int[nums.length];
//        a[0] = nums[0];
//        for(int i=1;i<nums.length;i++){
//            a[i] = a[i-1]+nums[i];
//        }
//        int max=Integer.MIN_VALUE;
//        int max_index=0;
//        int min=0;
//        int min_index=0;
//        for(int i=0;i<nums.length;i++){
//            if(a[i]>=max){
//                max=a[i];
//                max_index=i;
//            }
//        }
//        for(int i=0;i<max_index;i++){
//            if(a[i]<min){
//                min=a[i];
//                min_index=i;
//            }
//        }
//        int ans = max-min;
//        max=Integer.MIN_VALUE;
//        max_index=0;
//        min=0;
//        min_index=0;
//        for(int i=0;i<nums.length;i++){
//            if(a[i]<min){
//                min=a[i];
//                min_index=i;
//            }
//        }
//        for(int i=min_index;i<nums.length;i++){
//            if(a[i]>=max){
//                max=a[i];
//                max_index=i;
//            }
//        }
//        ans = Math.max(ans,max-min);
//        System.out.println(max);
//        System.out.println(min);
//        return ans;
        int pre=0;
        int ans=nums[0];
        for(int num:nums){
            if(pre>0){
                pre+=num;
            }else pre = num;
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,-1};
        num53 num53 = new num53();
        num53.maxSubArray(a);
    }
}
