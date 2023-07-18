package com.example.demo.repository;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentDAO {
    RestTemplate restTemplate = new RestTemplate();

    String url = "https://java-6-8ddd6-default-rtdb.asia-southeast1.firebasedatabase.app/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findAll() {
        return restTemplate.getForObject(url, StudentMap.class);
    }

    public StudentMap findByKey(String key) {
        return restTemplate.getForObject(getUrl(key), StudentMap.class);
    }

    public String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = restTemplate.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        restTemplate.put(getUrl(key), entity);
        return data;
    }

    public void delete(String key) {
        restTemplate.delete(getUrl(key));
    }
}
