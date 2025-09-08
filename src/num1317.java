public class num1317 {
    public int[] getNoZeroIntegers(int n) {
        int a=1;
        int b=n-1;
        while (String.valueOf(a).contains("0")||String.valueOf(b).contains("0")){
            a++;
            b--;
        }
        return new int[]{a,b};
    }
}
