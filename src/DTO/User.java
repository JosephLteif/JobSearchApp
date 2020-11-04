/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Lama
 */
public class User {
    int uid;
    String fname;
    String lname;
    String dob;
    String email;
    String password;
    String phoneNumber;
    String major;
    int gender;
    String location;
    int jobseekerdID;
    boolean isRecruiter;
    String university;

    public User() {
    }

    public User(String fname, String lname, String email, String password, int gender) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
    

    public User(String fname, String lname, String dob, String email, String password, int gender) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public User(int uid, String fname, String lname, String dob, String email, String password, int gender) {
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getJobseekerdID() {
        return jobseekerdID;
    }

    public void setJobseekerdID(int jobseekerdID) {
        this.jobseekerdID = jobseekerdID;
    }

    public boolean isIsRecruiter() {
        return isRecruiter;
    }

    public void setIsRecruiter(boolean isRecruiter) {
        this.isRecruiter = isRecruiter;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
    
 
}
