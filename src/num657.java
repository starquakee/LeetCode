public class num657 {
    public boolean judgeCircle(String moves) {
        int row=0;
        int column=0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                row++;
            } else if (c == 'D') {
                row--;
            } else if (c == 'L') {
                column--;
            } else if (c == 'R') {
                column++;
            }
        }
        return row == 0 && column == 0;
    }
}
