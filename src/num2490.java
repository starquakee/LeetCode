public class num2490 {
    public boolean isCircularSentence(String sentence) {
        String[] strings = sentence.split(" ");
        char[] begin = new char[strings.length] ;
        char[] end = new char[strings.length] ;
        for(int i=0;i<strings.length;i++){
            begin[i]=strings[i].charAt(0);
            end[i]=strings[i].charAt(strings[i].length()-1);
        }
        for(int i=0;i<strings.length;i++){
            if(end[i]!=begin[(i+1)%strings.length]){
                return false;
            }
        }
        return true;
    }
}
