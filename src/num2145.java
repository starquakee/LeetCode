public class num2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min=0L;
        long max=0L;
        long temp=0L;
        for(int i=0;i<differences.length;i++){
            temp+=differences[i];
            min=Math.min(min,temp);
            max=Math.max(max,temp);
        }
        long diff=max-min;
        return (int) Math.max(0,upper-diff-lower+1);
    }
}
