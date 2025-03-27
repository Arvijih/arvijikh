import java.util.ArrayList;

// Абстракт класс
abstract class Livestock {
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();

    void graze() {
        System.out.println(name + " талбайд бэлчинэ.");
    }

    void graze(String food) {
        System.out.println(name + " " + food + "-ыг бэлчинэ.");
    }
}

// Интерфейс
interface WorkRole {
    String performTask();
}

// Морь класс
class Horse extends Livestock implements WorkRole {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Янцгаана!";
    }

    @Override
    public String performTask() {
        return "Морь талбайд уналгад хэрэглэгдэнэ.";
    }
}

// Хонь класс
class Sheep extends Livestock {
    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Маа!";
    }
}

// Тэмээ класс
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Буйлна!";
    }

    @Override
    public String performTask() {
        return "Тэмээ говийн тээвэрт хэрэглэгдэнэ.";
    }
}

// Сүрэг класс
class Herd {
    ArrayList<Livestock> livestockList = new ArrayList<>();

    void addLivestock(Livestock animal) {
        livestockList.add(animal);
    }

    void dailyRoutine() {
        for (Livestock animal : livestockList) {
            System.out.println(animal.name + ": " + animal.makeSound());
            if (animal instanceof WorkRole) {
                System.out.println("  -> " + ((WorkRole) animal).performTask());
            }
        }
    }
}

// Main класс
public class LivestockSystem {
    public static void main(String[] args) {
        Herd herd = new Herd();

        Horse horse = new Horse("Шандаст", 5);
        Sheep sheep = new Sheep("Цагаан", 3);
        Camel camel = new Camel("Тэмүүлэн", 7);

        herd.addLivestock(horse);
        herd.addLivestock(sheep);
        herd.addLivestock(camel);

        herd.dailyRoutine();
    }
}
