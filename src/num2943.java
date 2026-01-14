import java.util.Arrays;

public class num2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int ans=1;
        int hMax=1;
        int vMax=1;
        int curr=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1)curr++;
            else curr=1;
            hMax=Math.max(hMax,curr);
        }
        curr=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1)curr++;
            else curr=1;
            vMax=Math.max(vMax,curr);
        }
        return Math.max(ans,(Math.min(hMax,vMax)+1)*(Math.min(hMax,vMax)+1));
    }
}
