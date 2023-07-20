import java.util.Arrays;

public class num287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int number=0;
        for(int num:nums){
            if(num==number)return num;
            number = num;
        }
        return 0;
    }
}
