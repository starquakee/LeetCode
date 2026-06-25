public class num3737 {
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : 0);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int total = j - i + 1;
                int targetCount = prefix[j + 1] - prefix[i];
                if (targetCount > total / 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
