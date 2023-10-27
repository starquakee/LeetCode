import java.util.Arrays;

public class num1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        for(int i=0;i<horizontalCuts.length;i++){
            if(i==0){
                maxA = horizontalCuts[0];
            } else {
                maxA = Math.max(maxA,horizontalCuts[i]-horizontalCuts[i-1]);
            }
        }
        maxA = Math.max(maxA,h-horizontalCuts[horizontalCuts.length-1]);
        for(int i=0;i<verticalCuts.length;i++){
            if(i==0){
                maxB = verticalCuts[0];
            } else {
                maxB = Math.max(maxB,verticalCuts[i]-verticalCuts[i-1]);
            }
        }
        maxB = Math.max(maxB,w-verticalCuts[verticalCuts.length-1]);
        long ans = (long) maxA*maxB% 1000000007;
        return (int) ans;
    }
}
