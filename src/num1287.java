public class num1287 {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        if (n==1)return arr[0];
        double thr=(double) n/4;
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                count++;
                if(count>thr)return arr[i];
            }else count=1;
        }
        return -1;
    }
}
