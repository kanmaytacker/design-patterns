package com.scaler.lld.design.creational.builder.student;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Student {
    
    String fname;
    String lname;
    String email;
    String phone;
    String address;

 
    public Student(Map<String, Object> studentValues) throws Exception {
        fname = (String) studentValues.get("fname");

        if (fname == null) {
            throw new Exception("fname is required");
        }
        this.lname = (String) studentValues.get("lname");
        this.email = (String) studentValues.get("email");
        this.phone = (String) studentValues.get("phone");
        this.address = (String) studentValues.get("address");
    }


}

// Type safety
// try catch
