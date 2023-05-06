import java.util.Scanner;

public class xiecheng1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String ans = convert(s);
        System.out.println(ans);

    }
    public static String convert(String s){
        char[] chars = s.toCharArray();
        StringBuilder ans= new StringBuilder();
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        for(int i=0;i<chars.length;i++){
            if(chars[i]>97&&chars[i]<=122){
                chars[i]-=1;
            } else if (chars[i]==97) {
                chars[i]=122;
            } else if (chars[i]>=65&&chars[i]<90) {
                chars[i]+=1;
            } else if (chars[i]==90) {
                chars[i]=65;
            }
            ans.append(chars[i]);
        }
        return ans.toString();
    }
}