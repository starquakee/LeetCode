import java.util.ArrayList;
import java.util.List;

public class num31 {
    public static List<Integer> generatePermutations(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutationsHelper(nums, used, currentPermutation, result);
        return result;
    }

    private static void generatePermutationsHelper(int[] nums, boolean[] used, List<Integer> currentPermutation, List<Integer> result) {
        if (currentPermutation.size() == nums.length) {
            int permutation = 0;
            for (int num : currentPermutation) {
                permutation = permutation * 10 + num;
            }
            result.add(permutation);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation.add(nums[i]);
                generatePermutationsHelper(nums, used, currentPermutation, result);
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> permutations = generatePermutations(nums);
        for (int permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
