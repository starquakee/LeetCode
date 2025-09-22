public class num3005 {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
            }
        }
        int sum = 0;
        for (int num : nums) {
            if(freq[num] == max) {
                sum++;
            }
        }
        return sum;
    }
}
