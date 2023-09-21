import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class huawei23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        while (input.hasNext()){
            String s = input.nextLine();
            if(s.contains(".")||s.contains(",")){
                System.out.println("<syntax-error>");
                continue;
            }
            if(s.startsWith("out")){
                if(map.containsKey(s.split("\\(")[1].split("\\)")[0])){
                    if(Long.parseLong(map.get(s.split("\\(")[1].split("\\)")[0]))<-2147483648){
                        System.out.println("<underflow>");
                    }else if(Long.parseLong(map.get(s.split("\\(")[1].split("\\)")[0]))>2147483647){
                        System.out.println("<overflow>");
                    }else System.out.println(map.get(s.split("\\(")[1].split("\\)")[0]));
                }else {
                    System.out.println("<undefined>");
                }
                continue;
            }
            String[] words = s.split(" ");
            if(words.length==4){
                char first = words[1].charAt(0);
                if((first-'a'>0&&first-'a'<'z'-'a')||(first-'A'>0&&first-'A'<'Z'-'A')||first=='_'){
                    map.put(words[1], words[3]);
                }else {
                    System.out.println("<syntax-error>");
                }

            }else if (words.length==6){
                if(Objects.equals(words[4], "+")){
                    map.put(words[1], String.valueOf(Long.parseLong(map.getOrDefault(words[3],words[3]))+Long.parseLong(map.getOrDefault(words[5],words[5]))));
                }else if(Objects.equals(words[4], "-")){
                    map.put(words[1], String.valueOf(Long.parseLong(map.getOrDefault(words[3],words[3]))-Long.parseLong(map.getOrDefault(words[5],words[5]))));
                }else if(Objects.equals(words[4], "*")){
                    map.put(words[1], String.valueOf(Long.parseLong(map.getOrDefault(words[3],words[3]))*Long.parseLong(map.getOrDefault(words[5],words[5]))));
                }else if(Objects.equals(words[4], "/")){
                    map.put(words[1], String.valueOf(Long.parseLong(map.getOrDefault(words[3],words[3]))/Long.parseLong(map.getOrDefault(words[5],words[5]))));
                }
            }else if(words.length==5){
                System.out.println("<syntax-error>");
            }
        }
    }
}
