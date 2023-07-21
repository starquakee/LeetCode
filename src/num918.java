import java.util.ArrayDeque;
import java.util.Queue;

public class num918 {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1)return nums[0];
        int max = nums[0];
        int[] dp = new int[nums.length];
        int[] leftSum = new int[nums.length];
        leftSum[0] = nums[0];
        dp[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum += nums[i];
            leftSum[i] = Math.max(leftSum[i-1],sum);
        }
        int rightSum=0;
        for(int i=nums.length-1;i>0;i--){
            rightSum+=nums[i];
            max = Math.max(max,rightSum+leftSum[i-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        Status status = Status.SUCCESS;
        System.out.println(status.getCode());
        Queue<Integer> queue = new ArrayDeque<>();

    }
}
enum Status {
    SUCCESS(200),
    NOT_FOUND(404),
    SERVER_ERROR(500);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}


