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
        System.out.println(name + " Talbaid belchine.");
    }

    void graze(String food) {
        System.out.println(name + " " + food + "-iig belchine.");
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
        return "Yntsgaana!";
    }

    @Override
    public String performTask() {
        return "Mori talbaid unalgad hereglegdene.";
    }
}

// Хонь класс
class Sheep extends Livestock {
    public Sheep(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Maa!";
    }
}

// Тэмээ класс
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Builna!";
    }

    @Override
    public String performTask() {
        return "Temee goviin teevert hereglegdene.";
    }
}

// Ямаа класс (шинэ мал)
class Goat extends Livestock {
    public Goat(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Mee!";
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

        Horse horse = new Horse("Horse", 5);
        Sheep sheep = new Sheep("Sheep", 3);
        Camel camel = new Camel("Camel", 7);
        Goat goat = new Goat("Goat", 2); // Шинэ мал

        herd.addLivestock(horse);
        herd.addLivestock(sheep);
        herd.addLivestock(camel);
        herd.addLivestock(goat); // Шинээр нэмэгдсэн ямаа

        herd.dailyRoutine();
    }
}
