import java.util.Arrays;

class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
    }

    public void update(int index, int val) {
        int preVal = preSum[index+1]-preSum[index];
        int diff = val-preVal;
        for(int i=index+1;i<preSum.length;i++){
            preSum[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        if(left==0)return preSum[right+1];
        return preSum[right+1]-preSum[left];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // 你的数组
        int left = 2; // 指定的左索引
        int addend = 10; // 你想要添加的数

        // 使用 Arrays.fill 方法填充指定范围的数组元素
        Arrays.fill(nums, left, nums.length, nums[left] + addend);

        // 输出修改后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}