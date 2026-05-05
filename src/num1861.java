public class num1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] ans=new char[boxGrid[0].length][boxGrid.length];
        for(int i=0;i<boxGrid.length;i++) {
            for (int j = 0; j < boxGrid[0].length; j++) {
                ans[j][boxGrid.length - 1 - i] = boxGrid[i][j];
            }
        }
        for(int i=0;i<ans[0].length;i++) {
            for (int j = ans.length-1; j >=0 ; j--) {
                if(ans[j][i]=='#') {
                    int k=j+1;
                    while (k<ans.length&&ans[k][i]=='.') {
                        k++;
                    }
                    ans[k-1][i]='#';
                    if(k-1!=j) {
                        ans[j][i]='.';
                    }
                }
            }
        }
        return ans;
    }
}
