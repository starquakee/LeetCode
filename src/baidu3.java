import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class baidu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        in.nextLine();
        Set<String> withType = new HashSet<>();
        Set<String> withoutType = new HashSet<>();
        Set<String> names = new HashSet<>();
        for(int z=0;z<q;z++){
            String opp = in.next();
            int op = Integer.parseInt(opp);

            String s = in.nextLine();

            System.out.println(s);
            if(op==1){
                //System.out.println(s);
                String with;
                String without;
                without = s.substring(s.indexOf(" ")+1).split("\\(")[0];
                //without = s.split(" ")[1].split("\\(")[0];
                without += "(";
                String[] paras;
                if(s.contains(",")){
                    paras = s.substring(s.indexOf(" ")+1).split("\\(")[1].split("\\)")[0].split(",");
                }else {
                    paras = new String[1];
                    paras[0] = s.substring(s.indexOf(" ")+1).split("\\(")[1].split("\\)")[0];
                }
                for(int i=0;i<paras.length;i++){
                    if(i<paras.length-1){
                        without+=paras[i].split(" ")[0]+",";
                    }else without+=paras[i].split(" ")[0];

                }
                without+=")";
                with = s.split(" ")[0]+without;
                if(!withType.contains(with)&&!withoutType.contains(without)){
                    withType.add(with);
                    withoutType.add(without);
                    names.add(without.split("\\(")[0]);
                    System.out.println("ok.");
                }
            }else{
                System.out.println(names);
                System.out.println(s.split("\\(")[0]);
                if(withoutType.contains(s)){
                    System.out.println("ok.");
                }else if(names.contains(s.split("\\(")[0])){
                    System.out.println("method "+s.split("\\(")[0]+" cannot be applied to given types.");
                }else {
                    System.out.println("cannot find symbol "+s.split("\\(")[0]);
                }
            }
        }
//7
//1
//int f(int x)
//1
//int g(int x,String s)
//2
//f()
//1
//void f(double x,double y)
//2
//f(double,double)
//2
//solve(int,String)
//1
//void f(int y)

    }
}
