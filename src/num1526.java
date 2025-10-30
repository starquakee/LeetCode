public class num1526 {
    public int minNumberOperations(int[] target) {
        int ans=target[0];
        for(int i=1;i<target.length;i++){
            ans+=Math.max(target[i]-target[i-1],0);
        }
        return ans;
    }
}
