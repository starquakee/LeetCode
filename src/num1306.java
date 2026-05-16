public class num1306 {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        int[] visited=new int[n];
        return dfs(arr,start,visited);
    }
    public boolean dfs(int[] arr,int start,int[] visited){
        if(start<0||start>=arr.length||visited[start]==1){
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        visited[start]=1;
        return dfs(arr,start+arr[start],visited)||dfs(arr,start-arr[start],visited);
    }
}
