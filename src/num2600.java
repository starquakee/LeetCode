public class num2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k<=numOnes+numZeros) return Math.min(k,numOnes);
        return numOnes-(k-numOnes-numZeros);
    }
}
