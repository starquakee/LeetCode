public class num12 {
    public static String intToRoman(int num) {
        String ans = "";
        int thousand = num / 1000;
        num = num%1000;
        for(int i=0;i<thousand;i++){
            ans += "M";
        }
        int a_500 = num / 500;
        if(a_500 == 1){ // 大于500
            num -= 500;
            if(num%500>=400){
                ans += "CM";
            }else {
                ans += "D";
                int a_100 = num / 100;
                for(int i=0;i<a_100;i++){
                    ans += "C";
                }
            }
        }else { //小于500
            if(num%500>=400){
                ans += "CD";
            }else {
                int a_100 = num / 100;
                for(int i=0;i<a_100;i++){
                    ans += "C";
                }
            }

        }
        num = num % 100;

        System.out.println(num);
        int a_50 = num / 50;
        if(a_50 == 1){ // 大于50
            num -= 50;
            if(num%50>=40){
                ans += "XC";
            }else {
                ans += "L";
                int a_10 = num / 10;
                for(int i=0;i<a_10;i++){
                    ans += "X";
                }
            }
        }else { //小于50
            if(num%50>=40){
                ans += "XL";
            }else {
                int a_10 = num / 10;
                for(int i=0;i<a_10;i++){
                    ans += "X";
                }
            }

        }
        num = num % 10;

        int a_5 = num / 5;
        if(a_5 == 1){ // 大于5
            num -= 5;
            if(num%5>=4){
                ans += "IX";
                return ans;
            }else {
                ans += "V";
                for(int i =0;i<num%5;i++){
                    ans+="I";
                }
                return ans;
            }
        }else { //小于5
            if(num%5>=4){
                ans += "IV";
                return ans;
            }else {
                int a_1 = num / 1;
                for(int i=0;i<a_1;i++){
                    ans += "I";
                }
                return ans;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(60));

    }
}
