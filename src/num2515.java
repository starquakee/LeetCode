public class num2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        for(int i=0;i<words.length;i++){
            if(words[(startIndex+i)%words.length].equals(target)){
                return i;
            }
            if(words[(startIndex-i+words.length)% words.length].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
