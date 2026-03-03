public class num1545 {
    public char findKthBit(int n, int k) {
        if(n==1)return '0';
        if(k==1<< (n-1))return '1';
        if(k>(1<< (n-1)))return (char) ('0'+('1'-findKthBit(n-1, (1<<n)-k)));
        return findKthBit(n-1, k);
    }
}
