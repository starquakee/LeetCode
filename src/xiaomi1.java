import java.util.Scanner;

public class xiaomi1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String sentence = input.nextLine();
            String[] words = sentence.split(" ");
            for(int i=words.length-1;i>0;i--){
                System.out.print(words[i]+" ");
            }
            System.out.println(words[0]);
        }
    }
}
