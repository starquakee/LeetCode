import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int x = 0, y = 0, d = 1;
        int ans = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 100000 + obstacle[1]);
        }
        for(int c:commands){
            if(c==-1){
                d = (d+1)%4;
            } else if(c==-2){
                d = (d+3)%4;
            }else {
                for(int i=0;i<c;i++){
                    x += dirs[d][0];
                    y += dirs[d][1];
                    if(set.contains(x*100000+y)){
                        x -= dirs[d][0];
                        y -= dirs[d][1];
                        break;
                    }
                    ans = Math.max(ans, x*x+y*y);
                }
            }
        }
        return ans;
    }
}
