public class num2103 {
    public int countPoints(String rings) {
        boolean[][] b = new boolean[10][30];
        for(int i=1;i<rings.length();i+=2){
            b[rings.charAt(i)-'0'][rings.charAt(i-1)-'A'] = true;
        }
        int ans = 0;
        for(int i=0;i<10;i++){
            if(b[i]['R'-'A']&&b[i]['G'-'A']&&b[i]['B'-'A'])ans++;
        }
        return ans;
    }
}
