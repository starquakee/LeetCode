public class num3136 {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        for(char c:word.toCharArray()){
            if(!((c>='0'&&c<='9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z')))return false;
        }
        boolean has1=false;
        boolean has2=false;
        for(char c:word.toLowerCase().toCharArray()){
            if(c>='a'&&c<='z'){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')has1=true;
                else has2=true;
            }
        }
        return has1&&has2;
    }
}
