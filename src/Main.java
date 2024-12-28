import models.School;
import models.Student;
import models.Teacher;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try (Scanner studentScanner = new Scanner(new File("src/students.txt"))) {
            while (studentScanner.hasNextLine()) {
                String[] data = studentScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = Boolean.parseBoolean(data[3]);
                Student student = new Student(name, surname, age, gender);
                school.addMember(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading students file.");
        }

        try (Scanner teacherScanner = new Scanner(new File("src/teachers.txt"))) {
            while (teacherScanner.hasNextLine()) {
                String[] data = teacherScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = Boolean.parseBoolean(data[3]);
                String subject = data[4];
                int yearsOfExperience = Integer.parseInt(data[5]);
                int salary = Integer.parseInt(data[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);

                if (yearsOfExperience > 10) {
                    teacher.giveRaise(5); // Повышаем на 5%
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading teachers file.");
        }

        System.out.println(school.toString());
    }
}
