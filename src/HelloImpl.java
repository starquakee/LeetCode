public class HelloImpl implements IHelloWorld {
    public Object hello(Object obj) {
        System.out.println("Hello World");
        return obj;
    }
}
