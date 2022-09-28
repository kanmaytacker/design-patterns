package com.scaler.lld.design.creational.builder.student;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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

        assertEquals("If name is set, on fetching it should be the same", "John", student.getFname());

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
        assertEquals("If name is set, on fetching it should be the same", "John", student.fname);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidStudent() {
        NewStudent.NewStudentBuilder builder = new NewStudent.NewStudentBuilder();
        builder.setEmail("")
                .setPhone("")
                .setAddress("");
        builder.build();
    }
}
