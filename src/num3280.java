public class num3280 {
    public String convertDateToBinary(String date) {
        String[] s= date.split("-");
        return binary(s[0])+"-"+binary(s[1])+"-"+binary(s[2]);

    }
    public String binary(String s){
        int num = Integer.parseInt(s);
        StringBuilder sb = new StringBuilder();
        while (num>0){
            sb.append(num&1);
            num = num>>1;
        }
        return sb.reverse().toString();
    }
}
