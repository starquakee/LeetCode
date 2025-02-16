public class num1299 {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[ans.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--){
            ans[i] = Math.max(arr[i+1],ans[i+1]);
        }
        return ans;
    }
}
