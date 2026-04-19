public class num1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans=0;
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]>nums2[j]){
                i++;
            } else {
                while (j < nums2.length&&nums1[i] <= nums2[j]){
                    j++;
                }
                ans=Math.max(ans,j-i-1);
            }
        }
        return ans;
    }
}
