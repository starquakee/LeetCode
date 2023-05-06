public class num13 {
    public static int romanToInt(String s) {
        int ans = 0;
        boolean a = true;
        for(int i=0;i<s.length()-1;i++){
            String temp = s.substring(i,i+2);
            if(!temp.equals("IV") && !temp.equals("IX") && !temp.equals("XL") && !temp.equals("XC") && !temp.equals("CD") && !temp.equals("CM")){
                switch (s.substring(i,i+1)){
                    case "I":ans+=1;break;
                    case "V":ans+=5;break;
                    case "X":ans+=10;break;
                    case "L":ans+=50;break;
                    case "C":ans+=100;break;
                    case "D":ans+=500;break;
                    case "M":ans+=1000;break;
                }
                a=true;
            }else {
                switch (temp){
                    case "IV":ans+=4;break;
                    case "IX":ans+=9;break;
                    case "XL":ans+=40;break;
                    case "XC":ans+=90;break;
                    case "CD":ans+=400;break;
                    case "CM":ans+=900;break;
                }
                i++;
                if(i==s.length()-1){
                    a=false;
                }
            }
        }
        if(a){
            switch (s.substring(s.length()-1)){
                case "I":ans+=1;break;
                case "V":ans+=5;break;
                case "X":ans+=10;break;
                case "L":ans+=50;break;
                case "C":ans+=100;break;
                case "D":ans+=500;break;
                case "M":ans+=1000;break;
            }
        }

        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        romanToInt("MDCXCV");

    }
}
