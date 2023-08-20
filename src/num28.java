public class num28 {
    public int strStr(String haystack, String needle) {
        char first = needle.charAt(0);
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==first){
                if(haystack.startsWith(needle, i)){
                    return i;
                }
            }
        }
        return -1;
    }
}
