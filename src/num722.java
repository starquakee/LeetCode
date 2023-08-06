import java.util.ArrayList;
import java.util.List;

public class num722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if(inBlock){
                    if(i+1<line.length()){
                        if(line.charAt(i)=='*'&&line.charAt(i+1)=='/'){
                            i++;
                            inBlock = false;
                        }
                    }
                }else {
                    if(i+1<line.length()){
                        if(line.charAt(i)=='/'&&line.charAt(i+1)=='/'){
                            break;
                        } else if (line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                            i++;
                            inBlock = true;
                        }else newLine.append(line.charAt(i));
                    }else newLine.append(line.charAt(i));
                }
            }
            if(!inBlock&&newLine.length()>0){
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }
}
