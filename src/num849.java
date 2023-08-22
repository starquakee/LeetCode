public class num849 {
    public int maxDistToClosest(int[] seats) {
        int ii=0;
        while (seats[ii]==0){
            ii++;
        }
        int pre = ii;
        int preMax = pre;
        int max = 0;
        boolean b = false;
        for(int i=ii+1;i<seats.length;i++){
            if(seats[i]==1){
                max = Math.max(max,i-pre);
                pre = i;
                b = true;
            }
        }
        int x = Math.max(preMax,seats.length-1-pre);
        if(x>max/2)return x;
        return max/2;
    }
}
