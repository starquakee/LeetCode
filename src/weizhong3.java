import java.util.Scanner;

public class weizhong3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int u = input.nextInt();
        int v = input.nextInt();
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i] = input.nextInt();
        }
        int coe = 1;
        int ans = 0;
        for(int i=v;coe*i<=length;coe++){
            int left = 0;
            int right = coe*i-1;
            long sum = 0;
            for(int z=0;z<=right;z++){
                sum += nums[z];
            }
            while (right<length){
                if(sum*v == (long) (right + 1 - left)*u){
                    ans++;
                }
                if(right+1<length){
                    sum -= nums[left];
                    sum += nums[right+1];
                }
                left++;
                right++;
            }
        }
        System.out.println(ans);
    }
}
