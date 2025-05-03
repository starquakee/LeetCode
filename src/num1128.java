public class num1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] arr = new int[9][9];
        for (int[] dominoe : dominoes) {
            int num1 = dominoe[0];
            int num2 = dominoe[1];
            arr[Math.max(num1,num2)-1][Math.min(num1,num2)-1]++;
        }
        int ans=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<=i;j++){
                if(arr[i][j]>1){
                    ans+=(arr[i][j]-1)*arr[i][j]/2;
                }
            }
        }
        return ans;
    }
}
