class ATM {
    int[] moneys;
    int[] values;

    public ATM() {
        moneys = new int[5];
        values = new int[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
            moneys[i]+=banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] take = new int[5];
        for(int i=4;i>=0;i--){
            int t = Math.min(moneys[i],amount/values[i]);
            amount -= t*values[i];
            take[i] = t;
        }
        if(amount>0)return new int[]{-1};
        else {
            for(int i=4;i>=0;i--)moneys[i]-=take[i];
            return take;
        }
    }
}
