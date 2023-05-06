import java.util.Random;
import java.util.Scanner;

public class xiecheng3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char[] chars = s.toCharArray();
        Boolean b=false;
        for(int i=0;i<chars.length;i++){
            if(i>=1){
                if(chars[i-1]==chars[i]&&chars[i-1]!='?'){
                    b=true;
                }
            }
            if(chars[i]=='?'){
                if(i==0){
                    if(chars.length>=3){
                        if(chars[1]=='0'){
                            if(chars[2]=='1'){
                                chars[i]='1';
                            }else {
                                chars[i]='2';
                            }
                        }
                        if(chars[1]=='1'){
                            b=true;
                        }
                        if(chars[1]=='2'){
                            if(chars[2]=='1'){
                                chars[i]='1';
                            }else {
                                chars[i]='0';
                            }
                        }
                    }else b=true;

                }
                if(i== chars.length-1){
                    if(chars.length>=3){
                        if(chars[chars.length-2]=='0'){
                            if(chars[chars.length-3]=='1'){
                                chars[i]='1';
                            }else {
                                chars[i]='2';
                            }
                        }
                        if(chars[chars.length-2]=='1'){
                            b=true;
                        }
                        if(chars[chars.length-2]=='2'){
                            if(chars[chars.length-3]=='1'){
                                chars[i]='1';
                            }else {
                                chars[i]='0';
                            }
                        }
                    }else b=true;

                }
                if(i>0&&i<chars.length-1){
                    if(chars[i-1]!=chars[i+1]){
                        if(chars[i+1]!='?'){
                            b=true;
                        }else {
                            if(chars[i-1]=='0'){
                                if(i-2>=0){
                                    if(chars[i-2]=='1'){
                                        chars[i]='1';
                                    }else chars[i]='2';
                                }else {
                                    chars[i]='2';
                                }

                            }
                            if(chars[i-1]=='1'){
                                b=true;
                            }
                            if(chars[i-1]=='2'){
                                if(chars[i-2]=='1'){
                                    chars[i]='1';
                                }else chars[i]='0';
                            }
                        }

                    }else {
                        if(chars[i-1]=='0') chars[i]='2';
                        else if (chars[i - 1] == '2') {
                            chars[i]='0';
                        } else if (chars[i - 1] == '1') {
                            if(i-2>=0){
                                b=true;
                            }if(i+2< chars.length){
                                b=true;
                            }
                            if(!b){
                                chars[i]='0';
                            }
                        }
                    }
                }
            }
        }
        StringBuilder ans= new StringBuilder();
        for(char c:chars){
//            System.out.println(c);
            ans.append(c);
        }
        if(b){
            System.out.println(-1);
        }else {
            System.out.println(ans.toString());
        }
        if(new Random().nextBoolean()){
            System.out.print(11);
        }else System.out.println(9);


    }
}
