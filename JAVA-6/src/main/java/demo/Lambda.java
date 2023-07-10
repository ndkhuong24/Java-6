package demo;

import java.util.*;

public class Lambda {
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
        Demo4Interface demo4Interface = x -> System.out.println(x);
        demo4Interface.m1(2021);
    }

    private static void demo3() {
        Collections.sort(list, (o1, o2) -> -o1.getMarks().compareTo(o2.getMarks()));
        list.forEach(student -> {
            System.out.println("Name " + student.getName());
            System.out.println("Gender " + student.getGender());
            System.out.println("Marks " + student.getMarks());
            System.out.println();
        });
    }

    private static void demo2() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Nguyễn Văn Tèo", true, 7.5));
        list.add(new Student("Nguyễn Thi Thu Hường", false, 5.5));
        list.add(new Student("Phạm Đức Cường", true, 9.5));
        list.forEach(student -> {
            System.out.println("Name " + student.getName());
            System.out.println("Gender " + student.getGender());
            System.out.println("Marks " + student.getMarks());
            System.out.println();
        });
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(n -> System.out.println(n));
    }
}

@FunctionalInterface
interface Demo4Interface {
    void m1(int x);

    default void m2() {
    }

    public static void m3() {
    }
}
