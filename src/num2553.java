import java.util.List;

public class num2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new java.util.ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                list.add(c - '0');
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
