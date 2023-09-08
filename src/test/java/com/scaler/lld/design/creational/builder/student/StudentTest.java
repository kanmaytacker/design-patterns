package com.scaler.lld.design.creational.builder.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;


public class StudentTest {

    @Test
    public void testStudent() {
        Map<String, Object> values = new HashMap<>();
        values.put("fname", "John");
        values.put("lname", "Doe");
        values.put("email", "");
        values.put("phone", "");

        Student student = null;
        try {
            student = new Student(values);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals("John", student.getFname(), "If name is set, on fetching it should be the same");

    }

    @Test
    public void testNewStudent() {
        NewStudent.NewStudentBuilder builder = new NewStudent.NewStudentBuilder();
        builder.setFname("John")
                .setLname("Doe")
                .setEmail("")
                .setPhone("")
                .setAddress("");
        NewStudent student = builder.build();
        assertEquals("John", student.fname, "If name is set, on fetching it should be the same");

    }

    @Test
    public void testValidStudent() {
        NewStudent.NewStudentBuilder builder = new NewStudent.NewStudentBuilder();
        builder.setEmail("")
                .setPhone("")
                .setAddress("");
        assertThrows(IllegalArgumentException.class, builder::build);

    }
}
