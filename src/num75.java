import java.util.Arrays;

public class num75 {
//    public static void sortColors(int[] nums) {
//        int zero = 0;
//        int one = 0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==0){
//                int temp = nums[zero];
//                nums[zero] = 0;
//                nums[i] = temp;
//                if (zero < one) {
//                    temp = nums[i];
//                    nums[i] = nums[one];
//                    nums[one] = temp;
//                }
//                zero++;
//                one++;
//            }else if(nums[i]==1){
//                int temp = nums[one];
//                nums[one] = 1;
//                nums[i] = temp;
//                one++;
//            }
//        }
//    }
    public void sortColors(int[] nums) {
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;
        for(int num:nums){
            if(num==0)zeroCount++;
            if(num==1)oneCount++;
            if(num==2)twoCount++;
        }
        for(int i=0;i<zeroCount;i++){
            nums[i]=0;
        }
        for(int i=zeroCount;i<zeroCount+oneCount;i++){
            nums[i]=1;
        }
        for(int i=zeroCount+oneCount;i<nums.length;i++){
            nums[i]=2;
        }
    }
}
