/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Wajaat
 */
public class StudentDataModel extends ListDataModel<Student> implements SelectableDataModel<Student>{

    public StudentDataModel(){
    }
    
    public StudentDataModel(List<Student> data){
        super(data);
    }
    
    @Override
    public Student getRowData(String rowKey){
        System.out.println(" Key = " + rowKey);
        List<Student> students = (List<Student>) getWrappedData();
        
        for(Student student: students){
            if(student.getId().equals(rowKey)){
                return student;
            } 
        }
        System.out.println("Valid Student not found");
        return null;
    }
    
    @Override
    public Object getRowKey(Student student){
        return student.getId();
    }
}
