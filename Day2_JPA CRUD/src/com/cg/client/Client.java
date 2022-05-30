package com.cg.client;

import com.cg.entities.Student;
import com.cg.services.StudentService;
import com.cg.services.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {
		StudentService obj = new StudentServiceImpl();
		Student student=new Student();
		
		/*//create
		student.setStudentId(104);
		student.setName("Afreen");
		obj.addStudent(student);*/
		//create
				student.setStudentId(103);
				student.setName("Roshan");
				obj.addStudent(student);
				
		
		/*//retrieve
		student = obj.findStudentById(101);
		System.out.println("Student Id: "+student.getStudentId());
		System.out.println("Student Name: "+student.getName());*/
		
		/*//update
		student=obj.findStudentById(101);
		student.setName("Hritik Jain");
		obj.updateStudent(student);*/
		
		//Delete
		student=obj.findStudentById(103);
		obj.removeStudent(student);
	}

}