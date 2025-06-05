public class num1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] c=new char[26];
        int n=s1.length();
        for(int i=0;i<26;i++){
            c[i]= (char) ('a'+i);
        }
        for(int i=0;i<n;i++){
            char char1=c[s1.charAt(i)-'a'];
            char char2=c[s2.charAt(i)-'a'];
            if(char1<char2){
                c[s2.charAt(i)-'a']=char1;
                for(int j=0;j<26;j++){
                    if(c[j]==char2)c[j]=char1;
                }
            }else {
                c[s1.charAt(i)-'a']=char2;
                for(int j=0;j<26;j++){
                    if(c[j]==char1)c[j]=char2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            sb.append(c[baseStr.charAt(i)-'a']);
        }
        return sb.toString();
    }
}
