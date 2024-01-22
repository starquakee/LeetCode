public class num670 {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int maxid = 0;
        int max = 0;
        int index1=0;
        int index2=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]-'0'>max){
                max = arr[i]-'0';
                maxid = i;
            }else if(arr[i]-'0'<max){
                index1 = i;
                index2 = maxid;

            }
        }
        swap(arr,index1,index2);
        return Integer.parseInt(new String(arr));
    }
    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
