import java.util.HashMap;
import java.util.Map;

public class num3483 {
    public int totalNumbers(int[] digits) {
        int[] arr=new int[10];
        for(int d:digits){
            arr[d]++;
        }
        int ans=0;
        for(int i=100;i<=998;i+=2){
            if(check(i,arr))ans++;
        }
        return ans;
    }
    public boolean check(int num, int[] arr) {
        int[] cnt = arr.clone();
        String s = String.valueOf(num);
        for (char ch : s.toCharArray()) {
            int d = ch - '0';
            if (cnt[d] <= 0) return false;
            cnt[d]--;
        }
        return true;
    }
}
