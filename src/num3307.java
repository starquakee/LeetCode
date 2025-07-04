import java.util.Arrays;

public class num3307 {
    public char kthCharacter(long k, int[] operations) {
        int operationCount=0;
        long[] arr = new long[100];
        arr[0]=1L;
        for(int i=1;i<100;i++){
            arr[i]=arr[i-1]*2;
            if(arr[i]>=k){
                operationCount=i;
                break;
            }
        }
        int changes=0;
        long temp=k;
        for(int i=operationCount-1;i>=0;i--){
            if(temp>arr[i]){
                temp-=arr[i];
                changes+=operations[i];
            }
        }
        return (char) ('a'+(changes%26));
    }
}
