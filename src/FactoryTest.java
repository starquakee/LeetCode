import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FactoryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入几组数字：");
        int numGroups = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        for (int i = 0; i < numGroups; i++) {
            System.out.print("请输入数字：");
            int number = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            System.out.print("请输入带空格的字符串：");
            String str = scanner.nextLine();

            // 在这里可以对读取到的数字和字符串进行处理
            System.out.println("数字：" + number);
            System.out.println("字符串：" + str);
        }

        // 关闭Scanner
        scanner.close();
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
