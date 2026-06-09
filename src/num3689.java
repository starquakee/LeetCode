public class num3689 {
    public long maxTotalValue(int[] nums, int k) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return (long) k *(max-min);
    }
}
