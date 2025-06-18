public class equalTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println("a == b: " + (a == b)); // 语句1

        Integer c = 10;
        Integer d = 10;
        System.out.println("c == d: " + (c == d)); // 语句2

        Integer e = 200;
        Integer f = 200;
        System.out.println("e == f: " + (e == f)); // 语句3

        String s1 = "hello";
        String s2 = "hello";
        System.out.println("s1 == s2: " + (s1 == s2)); // 语句4

        String s3 = new String("world");
        String s4 = new String("world");
        System.out.println("s3 == s4: " + (s3 == s4)); // 语句5

        String s5 = "java";
        String s6 = "ja" + "va";
        System.out.println("s5 == s6: " + (s5 == s6)); // 语句6

        String s7 = "java";
        String s8 = "ja";
        String s9 = s8 + "va";
        System.out.println("s7 == s9: " + (s7 == s9)); // 语句7
    }
}

