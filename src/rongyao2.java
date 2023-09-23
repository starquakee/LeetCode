import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rongyao2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (input.hasNext()){
            list.add(input.nextInt());
        }
        if(list.size()==1){
            System.out.println(list.get(0));
        }else {
            int left=0;
            int right=1;
            int ansL=0;
            int ansR=0;
            while (right<list.size()){
                if(list.get(right)<=list.get(right-1)){
                    right++;
                    if(right==list.size()){
                        if(right-1-left>=ansR-ansL){
                            ansL = left;
                            ansR = right-1;
                        }
                    }
                }else {
                    if(right-1-left>=ansR-ansL){
                        ansL = left;
                        ansR = right-1;
                        left = right;
                        right++;
                    }
                }
            }
            for(int i=ansL;i<=ansR;i++){
                System.out.print(list.get(i)+" ");
            }
        }
    }
}
