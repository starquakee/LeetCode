import java.util.Arrays;
import java.util.Comparator;

//需求：对String类型的数组进行排序
public class xiecheng4 implements Comparator<String> {

    public static void main(String[] args) {
        String[] str = {"abc","aa","abcd","abcde","bb","abcedf"};
        Arrays.sort(str, (a, b) -> a.length() - b.length());

        String [] arr={"haha","lala","ggg"};
        char [] ch={'a','g','b'};
        Arrays.sort(ch);


        sort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static  void sort(String [] arr){
        xiecheng4 testDemo2=new xiecheng4();

        for (int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                String str=null;
                if(testDemo2.compare(arr[i],arr[j])>0){
                    str=arr[j];
                    arr[j]=arr[i];
                    arr[i]=str;
                }
            }

        }
    }


    public int compare(String s1, String s2) {
        Character ch1= s1.charAt(0);
        Character ch2=s2.charAt(0);

        return (ch1-ch2)>0?1:(ch1-ch2)==0?0:-1;
    }
}



