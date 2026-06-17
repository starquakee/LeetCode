public class num1344 {
    public double angleClock(int hour, int minutes) {
        double h=(hour%12)*30+minutes*0.5;
        double m=minutes*6;
        return Math.min(Math.abs(m-h),360-(Math.abs(m-h)));
    }
}
