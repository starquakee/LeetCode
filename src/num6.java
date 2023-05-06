import java.util.Arrays;

public class num6 {
    public static String convert(String s, int numRows) {
        StringBuilder ans= new StringBuilder();
        char[][] chars = new char[numRows][(3*s.length()/numRows)+1];
        int j = 0;
        int k = 0;
        int i = 0;
        while (i<s.length()){
            for(int n=0;n<2*numRows-2&&i<s.length();n++){
                chars[j][k]=s.charAt(i);
                i+=1;
                if(n<numRows-1){
                    j+=1;
                }else if(n<2*numRows-2){
                    j-=1;
                    k+=1;
                }
            }
        }
        for (char[] aChar : chars) {
            for (int w = 0; w < chars[0].length; w++) {
                if (aChar[w] != '\0') {
                    ans.append(aChar[w]);
                }

//                System.out.print(aChar[w] + " ");
            }
//            System.out.println();
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));

    }
}
