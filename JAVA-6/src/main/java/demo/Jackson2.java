package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2 {
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
        demo7();
    }

    private static void demo7() throws IOException {
        Contact contact = new Contact("teonv@gmail.com", "0987456321", null);
        List<String> subjects = Arrays.asList("WEB205", "COM108");
        Student2 student2 = new Student2("Nguyễn Văn Tèo", true, 8.0, contact, subjects);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student2);
        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student2);
        mapper.writeValue(new File("C:\\Users\\kn134\\Downloads\\test\\student.json"), student2);
    }

    private static void demo6() throws IOException {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("email", "teonv@gmail.com");
        contact.put("phone", "0987654321");
        List<String> subjects = Arrays.asList("WEB205", "COM108");
        Map<String, Object> student = new HashMap<String, Object>();
        student.put("name", "Nguyễn Văn Tủm");
        student.put("marks", 7.5);
        student.put("gender", false);
        student.put("contact", contact);
        student.put("subjects", subjects);
        ObjectMapper mapper = new ObjectMapper();
        //write to String
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        //write to output
        mapper.writeValue(System.out, student);
        //write to file
        mapper.writeValue(new File("C:\\Users\\kn134\\Downloads\\test\\student.json"), student);
    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyễn Văn Tủm");
        student.put("marks", 8.5);
        student.put("gender", false);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "nguyenvana@gmail.com");
        contact.put("phone", "0987654321");
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("WEB205");
        subjects.add("COM108");
        //write to String
        String json = mapper.writeValueAsString(student);
        //write to output
        mapper.writeValue(System.out, student);
        //write to file
        mapper.writeValue(new File("C:/Users/kn134/Downloads/test/student.json"), student);
    }

    private static void demo4() throws Exception {
        String path = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\students.json";

    }

    private static void demo3() throws IOException {
        String path = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path), Student2.class);

        System.out.println(">> Name: " + student.getName());
        System.out.println(">> Marks: " + student.getMarks());
        System.out.println(">> Gender: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">> Email: " + contact.getEmail());
        System.out.println(">> Phone: " + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(s -> {
            System.out.println(">> Subject: " + s);
        });
    }

    private static void demo2() throws IOException {
        String path = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.forEach(System.out::println);
    }

    private static void demo1() throws IOException {
        String path = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);

        System.out.println(">>Name: " + student.get("name"));
        System.out.println(">>Marks: " + student.get("marks"));
        System.out.println(">>Gender: " + student.get("gender"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">>Email: " + contact.get("email"));
        System.out.println(">>Phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(System.out::println);
    }
}
