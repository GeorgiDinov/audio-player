package eu.deltasource.audioplayer.playable.audioplayable;

import eu.deltasource.audioplayer.MyErrorMessages;

public abstract class Person {

    private String name;
    private int age;

    protected Person(String name, int age) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            System.out.println(MyErrorMessages.INVALID_PARAMETER_MESSAGE);
            throw new IllegalArgumentException("name");
        }
        if (isValidAge(age)) {
            this.age = age;
        } else {
            System.out.println(MyErrorMessages.INVALID_PARAMETER_MESSAGE);
            throw new IllegalArgumentException("age");
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private boolean isValidName(String name) {
        return name != null && name.length() <= 30;
    }

    private boolean isValidAge(int age) {
        return age >= 0 && age <= 100;
    }

}
