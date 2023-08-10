public class num1281 {
    public int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        int mul=1,sum=0;
        for(int i=0;i<s.length();i++){
            mul *= s.charAt(i)-'0';
            sum += s.charAt(i)-'0';
        }
        return mul-sum;
    }
}
