import java.util.Arrays;

public class num3536 {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int[] arr = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            arr[i] = charArray[i] - '0';
        }
        Arrays.sort(arr);
        return arr[arr.length - 1] * arr[arr.length - 2];
    }
}
