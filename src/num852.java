public class num852 {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int l=0,r=n-1;
        int ans=0;
        while (l<=r){
            int mid=(r-l)/2+l;
            if(arr[mid]<arr[mid+1])l=mid+1;
            else {
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
}
