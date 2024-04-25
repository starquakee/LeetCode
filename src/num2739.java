public class num2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int all = 0;
        while (mainTank>=5&&additionalTank>0){
            mainTank-=4;
            additionalTank--;
            all+=5;
        }
        return 10*(all+mainTank);
    }
}
