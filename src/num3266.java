import java.util.PriorityQueue;

public class num3266 {
    private long quickMul(long x, long y, long mod) { //copied from LeetCode
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            y >>= 1;
            x = (x * x) % mod;
        }
        return res;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        int n = nums.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])return Long.compare(a[0],b[0]);
            else return Long.compare(a[1],b[1]);
        });
        int max=0;
        long mod = 1000000007L;
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            pq.offer(new long[]{nums[i],i});
        }
        int count=0;
        while (pq.peek()[0]<max&&count<k){
            count++;
            long[] temp = pq.poll();
            temp[0] *= multiplier;
            pq.offer(temp);
        }
        if(count<k){ // has loop
            int res = k-count;
            for(int i=0;i<n;i++){
                long[] temp = pq.poll();
                int exp =  (res/n)+(i<res%n?1:0);
                nums[(int) temp[1]] = (int) ((temp[0]%mod)*quickMul(multiplier,exp,mod)%mod);
            }
        }else { // no loop
            for(int i=0;i<n;i++){
                long[] temp = pq.poll();
                nums[(int) temp[1]] = (int) (temp[0]%mod);
            }
        }
        return nums;
    }
}
