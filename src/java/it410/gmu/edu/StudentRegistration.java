/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Wajaat
 */
@ManagedBean(name = "studentRegistration")
@SessionScoped
public class StudentRegistration {
    
    private Student student;
    private ArrayList<Student> students = new ArrayList<Student>(5);
    private List<Credits> creditsList = new ArrayList<Credits>();
    private StudentDataModel dataModel;
    private static int id = 1;
    
    private String[] courses = {"English", "Math 101", "Geometry", "Music 101", "Magic 101", 
                                "Drama 101", "Science Biology", "Science Geometry"};
    private String[] states = {"Virginia", "Maryland", "New York", "Florida", "Texas", "Ohio"};
    /**
     * Creates a new instance of StudentRegistration
     */
    public StudentRegistration() {
        student = new Student();
        dataModel = new StudentDataModel(students);
        
        creditsList.add(new Credits("Three", "3"));
        creditsList.add(new Credits("Six", "6"));
        creditsList.add(new Credits("Nine", "9"));
        creditsList.add(new Credits("Tweleve", "12"));
        creditsList.add(new Credits("Full", "16+"));
    }
    
    public String[] getStates(){
        return this.states;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getFname() {
        return student.getFname();
    }

    public void setFname(String fname) {
        student.setFname(fname);
    }

    public String getLname() {
        return student.getLname();
    }

    public void setLname(String lname) {
        student.setLname(lname);
    }

    public String getAddress() {
        return student.getAddress();
    }

    public void setAddress(String address) {
        student.setAddress(address);
    }

    public String getCity() {
        return student.getCity();
    }

    public void setCity(String city) {
        student.setCity(city);
    }

    public String getState() {
        return student.getState();
    }

    public void setState(String state) {
        student.setState(state);
    }

    public String getZip() {
        return student.getZip();
    }

    public void setZip(String zip) {
        student.setZip(zip);
    }
    
    public Date getRegDate() {
        return student.getRegDate();
    }

    public void setRegDate(Date regDate) {
        student.setRegDate(regDate);
    }

    public String getComments() {
        return student.getComments();
    }
    
    public void setComments(String comments) {
        student.setComments(comments);
    }
    
    public String getCredits() {
        return student.getCredits();
    }

    public void setCredits(String credits) {
        student.setCredits(credits);
    }
    
    public List<Credits> getCreditsList(){
        return this.creditsList;
    }

    public String getPayment() {
        return student.getPayment();
    }

    public void setPayment(String payment) {
        student.setPayment(payment);
    }

    public String[] getCourses() {
        return this.courses;
    }

    public String[] getSubjects() {
        return student.getSubjects();
    }

    public void setSubjects(String[] subjects) {
        student.subjects = subjects;
    }
    
    
    
    public void registerStudent(){
        System.out.println("First Name = " + student.getFname());
        System.out.println("Last Name = " + student.getLname());
        System.out.println("Adress = " + student.getAddress());
        System.out.println("City = " + student.getCity());
        System.out.println("State = " + student.getState());
        System.out.println("Zip = " + student.getZip());
        System.out.println("Registeration Date = " + student.getRegDate());
        System.out.println("Credits = " + student.getCredits());
        System.out.println("Payment = " + student.getPayment());
        System.out.println("Comments = " + student.getComments());
        
        String line = "";
        for(String subject: student.subjects){
            line = line + (subject + " ");
        }
       System.out.println("Subject = " + line);
       student.setId("" + id++);
    
        students.add(student);
        System.out.print("List Size = " + students.size() + " ---- Student id = " + student.getId());
        student = new Student();
    }
    
  
    public StudentDataModel getDataModel(){
        return this.dataModel;
    }
    
    public List searchStates(String searchCriteria){
      int i = 0;
      ArrayList result = new ArrayList();
      
      for(String state: getStates()){
          if(state.startsWith(searchCriteria)){
              result.add(state);
          }
      }
      return result;
  }
}
