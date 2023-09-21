import java.util.*;

public class huawei22 {
    public static boolean isSatisfied(int[][] arr,boolean[][] isVisited,int newX,int newY){
        int m = arr.length;
        int n = arr[0].length;
        if(newX<0||newX>=m||newY<0||newY>=n)return false;
        return arr[newX][newY] == 1 && !isVisited[newX][newY];
    }
    public static void main(String[] args) {
        int[][] d = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] arr = new int[m][n];
        int startNum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = input.nextInt();
                if(j==0&&arr[i][j]==1){
                    startNum++;
                    list.add(i);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<startNum;i++){
            Queue<String> queue = new ArrayDeque<>();
            boolean[][] isVisited = new boolean[m][n];
            int[][] distance = new int[m][n];
            int x = list.get(i);
            int y = 0;
            queue.offer(x+"&"+y);
            isVisited[x][y] = true;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int j=0;j<size;j++){
                    String temp = queue.poll();
                    x = Integer.parseInt(temp.split("&")[0]);
                    y = Integer.parseInt(temp.split("&")[1]);
                    for(int k=0;k<4;k++){
                        int newX = x+d[k][0];
                        int newY = y+d[k][1];
                        if(isSatisfied(arr,isVisited,newX,newY)){
                            queue.offer(newX+"&"+newY);
                            distance[newX][newY] = distance[x][y]+1;
                            isVisited[newX][newY] = true;
                        }
                    }
                }
            }
            for(int j=0;j<m;j++){
                if(arr[j][n-1]==1&&distance[j][n-1]!=0){
                    ans = Math.min(ans,distance[j][n-1]);
                }
            }
        }
        if(ans!=Integer.MAX_VALUE){
            System.out.println(ans);
        }else System.out.println(-1);
    }
}
