package eu.deltasource.audioplayer.playable.audioplayable;

import static eu.deltasource.audioplayer.util.MyMessages.INVALID_AGE;
import static eu.deltasource.audioplayer.util.MyMessages.INVALID_NAME;

public abstract class Person {

    private String name;
    private int age;

    protected Person(String name, int age) {
        this.name = validateName(name);
        this.age = validateAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private boolean isValidName(String name) {
        return name != null &&
                !name.isBlank() &&
                name.length() <= 30;
    }

    private String validateName(String name) {
        if (isValidName(name)) {
            return name;
        }
        throw new IllegalArgumentException(INVALID_NAME);
    }

    private boolean isValidAge(int age) {
        return age >= 0 && age <= 100;
    }

    private int validateAge(int age) {
        if (isValidAge(age)) {
            return age;
        }
        throw new IllegalArgumentException(INVALID_AGE);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
