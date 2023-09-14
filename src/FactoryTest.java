import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FactoryTest {
    public static void main(String[] args) {

        System.out.println(42&41);
        System.out.println();
        System.out.println(10/3.0);
        // 使用 CircleFactory 创建 Circle 对象
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw(); // 输出 "Draw a circle"

        // 使用 RectangleFactory 创建 Rectangle 对象
        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw(); // 输出 "Draw a rectangle"
        String[] fruits = {"apple", "banana", "grape", "kiwi", "orange"};

        // 使用自定义比较器对字符串数组进行排序（按字符串长度）
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        // 输出排序后的结果
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
