public class Spreadsheet {
    int[][] nums;
    public Spreadsheet(int rows) {
        nums = new int[rows][26];

    }

    public void setCell(String cell, int value) {
        nums[Integer.parseInt(cell.substring(1))-1][cell.charAt(0)-'A']=value;
    }

    public void resetCell(String cell) {
        nums[Integer.parseInt(cell.substring(1))-1][cell.charAt(0)-'A']=0;
    }

    public int getValue(String formula) {
        formula=formula.substring(1);
        String[] splits = formula.split("\\+");
        int ans=0;
        for(String split:splits){
            if(split.charAt(0)>='A'&&split.charAt(0)<='Z'){
                ans+=nums[Integer.parseInt(split.substring(1))-1][split.charAt(0)-'A'];
            }else {
                ans+=Integer.parseInt(split);
            }
        }
        return ans;
    }
}
