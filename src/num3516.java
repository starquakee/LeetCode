public class num3516 {
    public int findClosest(int x, int y, int z) {
        int a=Math.abs(y-z);
        int b=Math.abs(x-z);
        if(a==b)return 0;
        return  a>b?1:2;
    }
}
