interface Car {
    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪车在跑...");
    }
}

class Bmw implements Car {
    @Override
    public void run() {
        System.out.println("宝马车在跑...");
    }
}
interface ICarFactory {
    Car createCar();
}

// 2. 具体工厂：奥迪工厂和宝马工厂
class AudiFactory implements ICarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}

class BmwFactory implements ICarFactory {
    @Override
    public Car createCar() {
        return new Bmw();
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        // 想生产奥迪，就找奥迪工厂
        ICarFactory audiFactory = new AudiFactory();
        Car audi = audiFactory.createCar();
        audi.run();

        // 想生产宝马，就找宝马工厂
        ICarFactory bmwFactory = new BmwFactory();
        Car bmw = bmwFactory.createCar();
        bmw.run();
    }
}
