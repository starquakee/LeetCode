public class num2784 {
    public boolean isGood(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (num > nums.length - 1) {
                return false;
            }
            count[num]++;
            if (num <= 0 || (count[num] > 1&&num!=nums.length-1)) {
                return false;
            }
            if(num==nums.length-1&&count[num]>2){
                return false;
            }
        }
        return true;
    }
}
