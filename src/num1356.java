import java.util.Arrays;
import java.util.Collections;

public class num1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted((a,b)->{
            return Integer.bitCount(a)==Integer.bitCount(b)?a-b:Integer.bitCount(a)-Integer.bitCount(b);
        }).mapToInt(Integer::intValue).toArray();
    }
}
