public class num3296 {
    private static final double EPS = 1e-7;
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long ans=Long.MAX_VALUE;
        int maxWorkerTimes = 0;
        for (int t : workerTimes) {
            maxWorkerTimes = Math.max(maxWorkerTimes, t);
        }
        long left=0,right=(long) maxWorkerTimes * mountainHeight * (mountainHeight + 1) / 2;
        while(left<=right){
            long mid=left+(right-left)/2;
            long sum=0;
            for(int time:workerTimes){
                long work = mid / time;
                long k = (long)((-1.0 + Math.sqrt(1 + work * 8)) / 2+ EPS);
                sum += k;
            }
            if(sum>=mountainHeight){
                ans=Math.min(ans, mid);
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
