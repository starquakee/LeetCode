public class num2595 {
//    public int[] evenOddBit(int n) {
//        int even=0;
//        int odd=0;
//        int cnt=0;
//        while (n>0){
//            int temp=n%2;
//            if(temp==1){
//                if(cnt%2==0)even++;
//                else odd++;
//            }
//            cnt++;
//            n=n/2;
//        }
//        return new int[]{even,odd};
//    }
    public int[] evenOddBit(int n) {
        int even=0;
        int odd=0;
        String s = Integer.toBinaryString(n);
        for(int i=s.length()-1;i>=0;i-=2){
            if(s.charAt(i)=='1')even++;
        }
        for(int i=s.length()-2;i>=0;i-=2){
            if(s.charAt(i)=='1')odd++;
        }
        return new int[]{even,odd};
    }
}
