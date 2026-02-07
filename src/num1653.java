public class num1653 {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] dpA=new int[n];
        int[] dpB=new int[n];
        dpA[0]=s.charAt(0)=='a'?0:1;
        dpB[0]=s.charAt(0)=='b'?0:1;
        for(int i=1;i<n;i++) {
            if (s.charAt(i) == 'a') {
                dpA[i] = dpA[i - 1];
                dpB[i] = Math.min(dpA[i - 1], dpB[i - 1]) + 1;
            } else {
                dpA[i] = dpA[i - 1] + 1;
                dpB[i] = Math.min(dpA[i - 1], dpB[i - 1]);
            }
        }
        return Math.min(dpA[n - 1], dpB[n - 1]);
    }
}
