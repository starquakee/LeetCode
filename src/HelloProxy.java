import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloProxy implements java.lang.reflect.InvocationHandler {
    private final Object object;
    public HelloProxy(Object object){
        this.object = object;
    }
    public static Object newInstance(Object object) {
        return java.lang.reflect.Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),new HelloProxy(object));
    }


    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        try {
            System.out.println("before method " + m.getName());
            result = m.invoke(object, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            System.out.println("after method " + m.getName());
        }
        return result;
    }

    public static void main(String[] args) {
        IHelloWorld helloWorld = (IHelloWorld) HelloProxy.newInstance(new HelloImpl());
        helloWorld.hello(null);
    }
}
