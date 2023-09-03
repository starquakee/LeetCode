import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class weizhong2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i] = input.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }else {
                ans++;
                num++;
                while (set.contains(num)){
                    ans++;
                    num++;
                }
                set.add(num);
            }
        }
        System.out.println(ans);
    }
}
