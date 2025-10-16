import java.util.Arrays;

public class num2598 {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mods=new int[value];
        for(int num:nums){
            mods[((num%value)+value)%value]++;
        }
        int ans=0;
        while (mods[ans%value]>0){
            mods[ans%value]--;
            ans++;
        }
        return ans;
    }
}
