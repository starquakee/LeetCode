import java.util.Arrays;

public class num2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int[] original = new int[derived.length];
        original[0] = 0;
        for(int i = 1; i < derived.length; i++){
            if(derived[i-1]==0){
                original[i]=original[i-1];
            }else {
                original[i]=(original[i-1]+1)%2;
            }
        }
        if(derived[derived.length-1]==0){
            return original[0]==original[derived.length-1];
        }else  {
            return original[0]!=original[derived.length-1];
        }
    }
}
