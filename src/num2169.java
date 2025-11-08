public class num2169 {
    public int countOperations(int num1, int num2) {
        int ans=0;
        while (num1!=0&&num2!=0){
            ans += num1 / num2;
            num1 %= num2;
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return ans;
    }
}
