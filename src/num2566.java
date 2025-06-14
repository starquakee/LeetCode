public class num2566 {
    public int minMaxDifference(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        char change='9';
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='9')continue;
            change=charArray[i];
            break;
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]==change)charArray[i]='9';
        }
        int max=Integer.parseInt(new String(charArray));
        charArray = String.valueOf(num).toCharArray();
        change='0';
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='0')continue;
            change=charArray[i];
            break;
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]==change)charArray[i]='0';
        }
        int min=Integer.parseInt(new String(charArray));
        return max-min;
    }
}
