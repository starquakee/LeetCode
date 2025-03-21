import java.util.Arrays;
import java.util.Collections;

public class num2680 {
//    long ans;
//    long max=-1;
//    long max2=-1;
//    long[] numbers;
//    public long maximumOr(int[] nums, int k) {
//        if(k==0){
//            ans=numbers[0];
//            for(int i=1;i<numbers.length;i++){
//                ans|=numbers[i];
//            }
//            return ans;
//        }
//        if(max==-1){
//            numbers=new long[nums.length];
//            for(int i=0;i<numbers.length;i++){
//                numbers[i]=(long)nums[i];
//                max=Math.max(max,numbers[i]);
//            }
//            for (long number : numbers) {
//                if (number < max) max2 = Math.max(max2, number);
//            }
//            Arrays.sort(numbers);
//        }
//        int c=0;
//        while (true){
//            long num= (long) Math.pow(2,c);
//            if(num>max2){
//                if(max>=num){
//                    numbers[numbers.length-1]=numbers[numbers.length-1]<<k;
//                    ans=numbers[0];
//                    for(int i=1;i<numbers.length;i++){
//                        ans|=numbers[i];
//                    }
//                    return ans;
//                }else {
//                    if(k==1){
//                        long realAns=0;
//                        for(int i=0;i<numbers.length;i++){
//                            ans=0;
//                            for(int ii=0;ii<numbers.length;ii++){
//                                if(i==ii)ans|=numbers[ii]<<1;
//                                else ans|=numbers[ii];
//                            }
//                            realAns=Math.max(realAns,ans);
//                        }
//                        return realAns;
//                    }else {
//                        numbers[numbers.length-1]=numbers[numbers.length-1]<<k;
//                        ans=numbers[0];
//                        for(int i=1;i<numbers.length;i++){
//                            ans|=numbers[i];
//                        }
//                        return ans;
//                    }
//                }
//
//            }
//            c++;
//        }
//    }


    public long maximumOr(int[] nums, int k) {
        int n=nums.length;
        long[] prefix=new long[n];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]|nums[i-1];
        }
        long[] suffix=new long[n];
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]|nums[i+1];
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            long other=prefix[i]|suffix[i];
            ans=Math.max(ans,other|((long) nums[i] <<k));
        }
        return ans;
    }
}
