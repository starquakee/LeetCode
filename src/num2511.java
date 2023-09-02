public class num2511 {
    public int captureForts(int[] forts) {
        int i=0;
        int ans=0;
        while (i<forts.length){
            if(forts[i]==1){
                i++;
                int temp = 0;
                while (i<forts.length&&forts[i]==0){
                    temp++;
                    i++;
                }
                if(i<forts.length&&forts[i]==-1){
                    ans = Math.max(ans,temp);
                }
            }
            else if(forts[i]==-1){
                i++;
                int temp = 0;
                while (i<forts.length&&forts[i]==0){
                    temp++;
                    i++;
                }
                if(i<forts.length&&forts[i]==1){
                    ans = Math.max(ans,temp);
                }
            }else {
                while (i<forts.length&&forts[i]==0){
                    i++;
                }
            }
        }
        return ans;
    }
}
