package basic;

public abstract class Abstractclass_animal {


    public abstract void eat();

    public abstract void move();

    public void sleep() {
        System.out.println("Animal need sleeping.");
    }

    public void bark() {
        System.out.println("Animal need barking.");
    }

    public void walk() {
        System.out.println("dogout is walking.");
    }

    public static class Dog extends Abstractclass_animal {
        // @Override
        public void eat() {
            System.out.println("dog is eating.");
        }

        //@Override
        public void move() {
            System.out.println("dog is barking.");
        }

        public void walk() {
            System.out.println("dogin is walking.");
        }
    }

    public static class Cat extends Abstractclass_animal {
        // @Override
        public void eat() {
            System.out.println("cat is eating.");
        }

        public void move() {
            System.out.println("cat need move.");
        }

        ;

    }

    public static void main(String[] args) {
        Abstractclass_animal dog = new Abstractclass_animal.Dog();
        Abstractclass_animal cat = new Abstractclass_animal.Cat();

        dog.eat();
        dog.move();
        dog.sleep();
        dog.bark();
        dog.walk();

        cat.eat();
        cat.move();
        cat.sleep();
        cat.bark();
    }
}






