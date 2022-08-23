package project.gettersetter;

import java.time.LocalDate;

public class GetterSetter {
    public static void main(String[] args) {
        Student student = new Student();

//        student.setName("Tom");
        student.name = "Tom";
        student.setBirthDate(LocalDate.of(1950, 7, 4));

//        System.out.println(student.getName());
        System.out.println(student.name);
        System.out.println(student.getBirthDate());
        System.out.println(student.getAge());

        student.changeGrade("4.2");
        System.out.println(student.getGrade());
    }
}
