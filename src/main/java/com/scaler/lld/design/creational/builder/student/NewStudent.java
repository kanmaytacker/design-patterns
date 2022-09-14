package com.scaler.lld.design.creational.builder.student;

// Assignment - Figure out a way to avoid duplication and coupling in builder class
public class NewStudent {
    
    public String fname;
    String lname;
    String email;
    String phone;
    String address;
    int age;

    // Step 1 - Create an inner class with same fields as the outer class
    public static class NewStudentBuilder {

        String fname;
        String lname;
        String email;
        String phone;
        String address;


    public String getFname() {
        return this.fname;
    }

    public NewStudentBuilder setFname(String fname) {
        this.fname = fname;
        return this;
    }

    public String getLname() {
        return this.lname;
    }

    public NewStudentBuilder setLname(String lname) {
        this.lname = lname;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public NewStudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public NewStudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public NewStudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    private boolean validate() {
        if (fname == null || lname == null) {
            return false;
        }

        return true;
    }

    // Step 2 - Add a build method to create outer class
    public NewStudent build() {

        // Step 4 - Validation
        boolean isValid = validate();
        if (!isValid) {
            throw new IllegalArgumentException("Invalid student");
        }

        NewStudent student = new NewStudent();
        student.fname = this.fname;
        student.lname = this.lname;
        student.email = this.email;
        student.phone = this.phone;
        student.address = this.address;
        return student;
    }

    }
}
