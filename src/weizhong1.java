import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class weizhong1 {//chouxianglei bixuyou chouxiang fangfama
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i] = input.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        boolean b = false;
        for(int i=0;i<length;i++){
            if(set.contains(nums[i])){
                System.out.println(i);
                b = true;
                break;
            }else {
                set.add(nums[i]);
            }
        }
        if(!b)System.out.println(length);
    }
}
