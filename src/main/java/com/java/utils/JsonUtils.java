package com.java.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Employee;

import java.io.IOException;
import java.io.InputStream;

// ObjectMapper by jackson
public class JsonUtils {

    public static void main(String[] args) throws Exception {

        Employee e = new Employee();
        e.setId(10);
        e.setName("John");
        toJson(e);

        InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream("data.json");
        toObject(is);

    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static void toObject(InputStream is) throws IOException {
        Employee e = MAPPER.readValue(is, Employee.class);
        System.out.println(e.getId());
        System.out.println(e.getName());
    }

    private static void toJson(Object object) throws JsonProcessingException {
        String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        System.out.println(json);
    }
}
