public class num1523 {
    public int countOdds(int low, int high) {
        int temp=low%2==1||high%2==1?1:0;
        return (high-low)/2+temp;
    }
}
