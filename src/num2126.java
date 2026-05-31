import java.util.Arrays;

public class num2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (sum < asteroids[i]) {
                return false;
            }
            sum += asteroids[i];
        }
        return true;
    }
}
