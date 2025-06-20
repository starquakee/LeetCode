public class num3443 {
    public int maxDistance(String s, int k) {
        int numN=0;
        int numS=0;
        int numW=0;
        int numE=0;
        int ans;
        int res=0;
        for(char c:s.toCharArray()){
            switch (c){
                case 'N':
                    numN++;
                    break;
                case 'S':
                    numS++;
                    break;
                case 'W':
                    numW++;
                    break;
                case 'E':
                    numE++;
                    break;
            }
            ans=Math.abs(numN-numS)+Math.abs(numW-numE);
            int minNS=Math.min(numN,numS);
            int minWE=Math.min(numW,numE);
            int newK=k;
            if(minNS>k){
                ans+=2*k;
            }else {
                newK=k-minNS;
                ans+=2*minNS;
                if(minWE>newK){
                    ans+=2*newK;
                }else {
                    ans+=2*minWE;
                }
            }
            res=Math.max(res,ans);
        }
        return res;
    }
}
