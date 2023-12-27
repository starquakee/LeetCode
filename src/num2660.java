public class num2660 {
    public int isWinner(int[] player1, int[] player2) {
        boolean[] isTwice1 = new boolean[player1.length];
        boolean[] isTwice2 = new boolean[player2.length];
        if(player1.length>1){
            if(player1[0]==10)isTwice1[1] = true;
            if(player2[0]==10)isTwice2[1] = true;
        }
        for(int i=2;i<player1.length;i++){
            if(player1[i-2]==10||player1[i-1]==10){
                isTwice1[i] = true;
            }
            if(player2[i-2]==10||player2[i-1]==10){
                isTwice2[i] = true;
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0;i<player1.length;i++){
            if(isTwice1[i]){
                ans1 += player1[i]*2;
            }else ans1 += player1[i];
            if(isTwice2[i]){
                ans2 += player2[i]*2;
            }else ans2 += player2[i];
        }
        System.out.println(ans1+" "+ans2);
        if(ans1>ans2)return 1;
        if(ans1<ans2)return 2;
        return 0;
    }
}
