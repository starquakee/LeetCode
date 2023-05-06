public class num7 {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        long l = 0L;
        if(chars[0]=='-'){
            for(int i=1;i<chars.length;i++){
                l += (chars[i]-48)*Math.pow(10, i-1);
            }
            l = -l;
            if(l<-Math.pow(2,32)){
                return 0;
            }
            System.out.println(l);
        }else {
            for(int i=0;i<chars.length;i++){
                l += (chars[i]-48)*Math.pow(10, i);
            }
            if(l>Math.pow(2,31)-1){
                return 0;
            }
            System.out.println(l);
        }
        int ans = (int) l;
        return ans;
    }
    public static void main(String[] args) {
        long max = (long) (Math.pow(2,31)-1);
        System.out.println(max);
        System.out.println(reverse(1563847412));

    }
}
