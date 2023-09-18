public class numLCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for(int[] operation:operations){
            int x = gem[operation[0]]/2;
            gem[operation[0]] -= x;
            gem[operation[1]] += x;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : gem) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        return max-min;
    }
}
