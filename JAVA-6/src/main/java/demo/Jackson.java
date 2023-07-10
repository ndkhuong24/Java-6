package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson {
    public static void main(String[] args) throws IOException {
//        demo1();
        demo2();
    }


    private static void demo2() throws IOException {
        String json = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(json));
        students.iterator().forEachRemaining(jsonNode -> {
            System.out.println(">>Name: "+jsonNode.get("name").asText());
        });
    }

    private static void demo1() throws IOException {
        String json = "C:\\Users\\kn134\\Downloads\\JAVA-6\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(json));

        System.out.println(">>Name: " + student.get("name").asText());
        System.out.println(">>Marks: " + student.get("marks").asText());
        System.out.println(">>Gender: " + student.get("gender").asBoolean());
        System.out.println(">>Email: " + student.get("contact").get("email").asText());
        System.out.println(">>Phone: " + student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(jsonNode -> {
            System.out.println(">>Subject: " + jsonNode.asText());
        });
    }
}
