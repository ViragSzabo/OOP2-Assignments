package Week1.Example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Piet", 1) {
            @Override
            public String getSound() {
                return "All animals have a sound.";
            }

            @Override
            public String fly() {
                return "Not every animal can fly.";
            }
        };
        Animal bird = new Bird("Kanarie", 1);
        bird.getSound();

        Animal bird2 = new Bird("Another Kanarie", 2);
        bird2.fly();
        bird.fly();

        Animal cow = new Cow("Berta", 4, 5);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(bird);
        animals.add(bird2);
        animals.add(cow);

        for (Animal a : animals) {
            a.getSound();
        }
    }
}