package com.java.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Employee;
import com.java.model.University;

import java.io.IOException;
import java.io.InputStream;

// ObjectMapper by jackson
public class JsonUtils {

    public static void main(String[] args) throws Exception {

        Employee e = new Employee();
        e.setId(10);
        e.setName("John");
        toJson(e);

        University u = new University();
        u.setEstd("1940");
        u.setVcName("ALex");
        u.setDeptCount(40);
        toJson(u);

        // take another file called university.json and convert it to University object. just like below.
        InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream("data.json");

        Employee e1 = toObject(is, Employee.class );
        System.out.println(e1.getId());
        System.out.println(e1.getName());

    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static <T> T toObject(InputStream is, Class<T> classType) throws IOException {
        T o = MAPPER.readValue(is, classType);
        return o;
    }

    private static void toJson(Object object) throws JsonProcessingException {
        String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        System.out.println(json);
    }
}
