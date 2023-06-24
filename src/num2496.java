public class num2496 {
    public int maximumValue(String[] strs) {
        int max=0;
        for(String str:strs){
            int num;
            if(isNumeric(str)){
                num= Integer.parseInt(str);
            }else {
                num=str.length();
            }
            max=Math.max(max,num);
        }
        return max;
    }
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
