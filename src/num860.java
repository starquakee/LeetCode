public class num860 {
    public boolean lemonadeChange(int[] bills) {
        int num_5 = 0,num_10 = 0;
        for(int bill:bills){
            if(bill==5){
                num_5++;
            }else if(bill==10){
                if(num_5>0){
                    num_10++;
                    num_5--;
                }else return false;
            }else if(bill==20){
                if(num_10>0&&num_5>0){
                    num_10--;
                    num_5--;
                } else if (num_5 > 2) {
                    num_5 -= 3;
                }else return false;
            }
        }
        return true;
    }
}
