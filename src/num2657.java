public class num2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] ans=new int[n];
        int count=0;
        boolean[] visited=new boolean[n+1];
        for(int i=0;i<n;i++) {
            if (visited[A[i]]) {
                count++;
            }
            visited[A[i]] = true;
            if (visited[B[i]]) {
                count++;
            }
            visited[B[i]] = true;
            ans[i] = count;
        }
        return ans;
    }
}
