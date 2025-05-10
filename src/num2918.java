public class num2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0L,sum2=0L;
        long zeroCount1=0,zeroCount2=0L;
        for(Integer num:nums1){
            sum1+=num;
            if(num==0)zeroCount1++;
        }
        for(Integer num:nums2){
            sum2+=num;
            if(num==0)zeroCount2++;
        }
        long min1=sum1+zeroCount1;
        long min2=sum2+zeroCount2;
        if(min1<min2){
            if(zeroCount1==0)return -1;
        }
        if(min2<min1){
            if(zeroCount2==0)return -1;
        }
        return Math.max(min1,min2);
    }
}
