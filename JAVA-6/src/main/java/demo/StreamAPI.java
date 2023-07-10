package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    static List<Student> list = Arrays.asList(
            new Student("Nguyễn Văn A", true, 9.5),
            new Student("Nguyễn Văn B", false, 6.5),
            new Student("Nguyễn Văn C", true, 7.5)
    );

    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    private static void demo4() {
        double average = list.stream().mapToDouble(value -> value.getMarks()).average().getAsDouble();
        System.out.println("average: " + average);

        double sum = list.stream().mapToDouble(value -> value.getMarks()).sum();
        System.out.println("sum: " + sum);

        double min = list.stream().mapToDouble(value -> value.getMarks()).min().getAsDouble();
        System.out.println("min: " + min);

        boolean all_passed = list.stream().allMatch(student -> student.getMarks() >= 5);
        System.out.println("all_passed: " + all_passed);

        Student min_sv = list.stream().reduce(list.get(0), (minStudent, sv) -> sv.getMarks() < minStudent.getMarks() ? sv : minStudent);
        System.out.println("min_sv: " + min_sv.getName());
    }

    private static void demo3() {
        List<Student> result = list.stream()
                .filter(student -> student.getMarks() > 7)
                .peek(student -> student.setName(student.getName().toUpperCase()))
                .collect(Collectors.toList());
        result.forEach(student -> {
            System.out.println(">>Name: " + student.getName());
            System.out.println(">>Marks: " + student.getMarks());
            System.out.println();
        });

    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        List<Double> result = list.stream().
                filter(integer -> integer % 2 == 0).
                map(integer -> Math.sqrt(integer)).
                peek(System.out::println).
                collect(Collectors.toList());
    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(1, 9, 4, 7, 5, 2);
        stream1.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(System.out::println);
    }
}
