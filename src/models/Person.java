package models;

public class Person {
    private String name;
    private String surname;
    private int age;
    private boolean gender;

    // Конструктор
    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    // Метод для вывода информации о человеке
    public String toString() {
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + (gender ? "Male" : "Female") + ".";
    }
}
