import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        for(int i=0;i<(1<<n);i++){
            StringBuilder sb=new StringBuilder(Integer.toBinaryString(i));
            while (sb.length()<n){
                sb.insert(0,0);
            }
            if(!set.contains(sb.toString())){
               return sb.toString();
            }
        }
        return "";
    }
}
