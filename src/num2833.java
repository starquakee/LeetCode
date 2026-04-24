public class num2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int ans=0;
        int l=0;
        int r=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')l++;
            else if(moves.charAt(i)=='R')r++;
            else ans++;
        }
        return ans+Math.abs(l-r);
    }
}
