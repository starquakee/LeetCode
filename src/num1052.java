import java.util.Arrays;

public class num1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] satisfy = new int[customers.length];
        int[] window = new int[customers.length];
        for(int i=0;i<customers.length;i++){
            satisfy[i] = customers[i]*(1-grumpy[i]);
        }
        for(int i=0;i<minutes;i++){
            window[minutes-1] += customers[i]*grumpy[i];
        }
        int max = window[minutes-1];
        for(int i=minutes;i<customers.length;i++){
            window[i] = window[i-1]+customers[i]*grumpy[i]-customers[i-minutes]*grumpy[i-minutes];
            max = Math.max(max,window[i]);
        }
        return max+ Arrays.stream(satisfy).sum();
    }
}
