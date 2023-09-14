import java.util.*;
public class num1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] queen:queens){
            set.add(queen[0]*10 + queen[1]);
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for(int i=0;i<8;i++){
            int newX=king[0];
            int newY=king[1];
            while (newX<8&&newX>=0&&newY<8&&newY>=0){
                newX += dir[i][0];
                newY += dir[i][1];
                if(set.contains(newX*10+newY)){
                    List<Integer> one = new ArrayList<>();
                    one.add(newX);
                    one.add(newY);
                    ans.add(one);
                    break;
                }
            }
        }
        return ans;
    }
}
