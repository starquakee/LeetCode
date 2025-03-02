import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num132 {
    // backtracking will out of time
//    int[][] f;
//
//    int minCut=999999;
//    int temp=0;
//    public int minCut(String s) {
//        f = new int[s.length()][s.length()];
//        dfs(s,0,0);
//        return minCut;
//    }
//    public void dfs(String s,int i,int time){
//        if(i==s.length()) {
//            minCut=Math.min(minCut, temp-1);
//            return;
//        }
//        for(int j=s.length()-1;j>=i&&time<=minCut+1;j--){
//            if(isPar(s,i,j)==1){
//                temp++;
//                dfs(s,j+1,temp);
//                temp--;
//            }
//        }
//    }
//    public int isPar(String s,int begin,int end){
//        if(f[begin][end]!=0)return f[begin][end];
//        if(begin>=end){
//            f[begin][end]=1;
//            return f[begin][end];
//        }
//        if(isPar(s,begin+1,end-1)==1){
//            if(s.charAt(begin)==s.charAt(end)){
//                f[begin][end]=1;
//                return f[begin][end];
//            }
//        }
//        f[begin][end]=-1;
//        return f[begin][end];
//    }


    // dp
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
