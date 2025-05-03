public class num1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        int topNum=0;
        int bottomNum=0;
        boolean isSuccess;
        for(int i=1;i<=6;i++){
            isSuccess=true;
            for(int j=0;j<n;j++){
                if(tops[j]!=i&&bottoms[j]!=i){
                    topNum=0;
                    bottomNum=0;
                    isSuccess=false;
                    break;
                }
                if(tops[j]==i)topNum++;
                if(bottoms[j]==i)bottomNum++;
            }
            if(isSuccess){
                return Math.min(n-topNum,n-bottomNum);
            }
        }
        return -1;
    }
}
