public class num3304 {
    public char kthCharacter(int k) {
        char[] arr = new char[2*k];
        arr[0]='a';
        int endIndex=0;
        while (endIndex<k){
            for(int i=0;i<=endIndex;i++){
                if(arr[i]=='z'){
                    arr[endIndex+i+1]='a';
                } else arr[endIndex+i+1]= (char) (arr[i]+1);
            }
            endIndex=2*endIndex+1;
        }
        return arr[k-1];
    }
}
