public class num744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int left=0;
        int right=n-1;
        char ans=letters[0];
        if(target>=letters[n-1]){
            return ans;
        }
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = letters[mid];
            }
        }
        return ans;
    }
}
