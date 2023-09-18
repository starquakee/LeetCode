import java.util.List;

public class num2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i=0;i<nums.size();i++){
            if(getCnt(i)==k){
                ans += nums.get(i);
            }
        }
        return ans;
    }
    public int getCnt(int i){
        int cnt = 0;
        while(i > 0){
            if((i&1) == 1) cnt++;
            i >>= 1;
        }
        return cnt;
    }
}
