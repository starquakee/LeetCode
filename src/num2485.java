public class num2485 {
    public static int pivotInteger(int n) {
        int x2 = n*(n+1)/2;
        double x = Math.sqrt(x2);
        if(x%1==0){
            return (int)x;
        }else return -1;
    }
}
