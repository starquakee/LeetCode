public class num1432 {
    public int maxDiff(int num) {
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
        change='a';
        boolean isFirst=false;
        for(int i=0;i<charArray.length;i++){
            if(i==0&&charArray[i]=='1')continue;
            if(charArray[i]=='0')continue;
            if(i>0&&charArray[i]==charArray[0])continue;
            if(i==0)isFirst=true;
            change=charArray[i];
            break;
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]==change){
                if(isFirst){
                    charArray[i]='1';
                }else charArray[i]='0';
            }
        }
        int min=Integer.parseInt(new String(charArray));
        return max-min;
    }
}
