import java.util.Arrays;

public class num1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        int[] arr = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            arr[calNum(i)]++;
        }
        max = Arrays.stream(arr).max().getAsInt();
        return max;
    }

    public int calNum(int num) {
        int ans = 0;
        while (num / 10 != 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans + num;
    }
}
