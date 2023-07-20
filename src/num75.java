import java.util.Arrays;

public class num75 {
    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int temp = nums[zero];
                nums[zero] = 0;
                nums[i] = temp;
                if (zero < one) {
                    temp = nums[i];
                    nums[i] = nums[one];
                    nums[one] = temp;
                }
                zero++;
                one++;
            }else if(nums[i]==1){
                int temp = nums[one];
                nums[one] = 1;
                nums[i] = temp;
                one++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,0,2,1,1,0};
        sortColors(a);
    }


}
