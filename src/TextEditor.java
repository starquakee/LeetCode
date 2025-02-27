import java.util.ArrayList;
import java.util.List;
// out of time
//public class TextEditor {
//    List<Character> list;
//    int index;
//    public TextEditor() {
//        list = new ArrayList<>();
//        index=0;
//    }
//
//    public void addText(String text) {
//        for(char c:text.toCharArray()){
//            list.add(index++,c);
//        }
//    }
//
//    public int deleteText(int k) {
//        if(k<=index){
//            list.subList(index-k,index).clear();
//            index=index-k;
//            return k;
//        }else {
//            list.subList(0,index).clear();
//            int ans=index;
//            index=0;
//            return ans;
//        }
//    }
//
//    public String cursorLeft(int k) {
//        index=Math.max(0,index-k);
//        int num=Math.min(10,index);
//        StringBuilder ans= new StringBuilder();
//        for(int i=0;i<num;i++){
//            ans.append(list.get(index - num + i));
//        }
//        return ans.toString();
//    }
//
//    public String cursorRight(int k) {
//        int size=list.size();
//        index=Math.min(index+k,size);
//        int num=Math.min(10,index);
//        StringBuilder ans= new StringBuilder();
//        for(int i=0;i<num;i++){
//            ans.append(list.get(index - num + i));
//        }
//        return ans.toString();
//    }
//}
public class TextEditor {
    StringBuilder list;
    int index;
    public TextEditor() {
        list= new StringBuilder();
        index=0;
    }

    public void addText(String text) {
        list.insert(index,text);
        index+=text.length();
    }

    public int deleteText(int k) {
        if(k<=index){
            list.delete(index-k,index);
            index=index-k;
            return k;
        }else {
            list.delete(0,index);
            int ans=index;
            index=0;
            return ans;
        }
    }

    public String cursorLeft(int k) {
        index=Math.max(0,index-k);
        int num=Math.min(10,index);
        return list.substring(index-num,index);
    }

    public String cursorRight(int k) {
        int size=list.length();
        index=Math.min(index+k,size);
        int num=Math.min(10,index);
        return list.substring(index-num,index);
    }
}
