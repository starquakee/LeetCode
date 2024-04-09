public class num2529 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int neg_index = -1;
        int pos_index = n;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(mid+1>=n){
                if(nums[mid]<0)return n;
                else return n-1;
            }
            if(nums[mid]<0 && nums[mid+1]>=0){
                neg_index = mid;
                break;
            }
            if(nums[mid]<0 && nums[mid+1]<0){
                left = mid+1;
                continue;
            }
            if(nums[mid]>=0){
                right = mid-1;
                continue;
            }
        }
        left=0;
        right=n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(mid-1<0){
                if(nums[mid]>0)return n;
                else return n-1;
            }
            if(nums[mid]>0 && nums[mid-1]<=0){
                pos_index = mid;
                break;
            }
            if(nums[mid]>0 && nums[mid-1]>0){
                right = mid-1;
                continue;
            }
            if(nums[mid]<=0){
                left = mid+1;
                continue;
            }
        }
        return Math.max(neg_index+1,n-pos_index);
    }
}
