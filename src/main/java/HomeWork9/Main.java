package HomeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Роман", Arrays.asList(new Course("Math"), new Course("Biology"),
                new Course("Geography"))));
        students.add(new Student("Кирилл", Arrays.asList(new Course("Math"), new Course("Geography"),
                new Course("Chemistry"), new Course("Language"))));
        students.add(new Student("Матвей", Arrays.asList(new Course("Physics"), new Course("Language"),
                new Course("History"), new Course("Sport"))));


        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));


        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));


        Course course = new Course("Language");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
