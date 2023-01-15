package com.programming.concepts.aggregation;

import java.util.ArrayList;
import java.util.List;
// Output Explanation: In this example, there is an Institute which has no. of departments like CSE, EE. Every department has no. of students. 
//So, we make an Institute class that has a reference to Object or no. of Objects (i.e. List of Objects) of the Department class.
//That means Institute class is associated with Department class through its Object(s). 
//And Department class has also a reference to Object or Objects (i.e. List of Objects) of the Student class means it is associated with the Student class through its Object(s). 
// It represents a Has-A relationship. In the above example: Student Has-A name. Student Has-A ID. Student Has-A Dept. Department Has-A Students as depicted from the below media. 
public class AggregationMain {

    // main driver method
    public static void main(String[] args)
    {
        // Creating object of Student class inside main()
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");
 
        // Creating a List of CSE Students
        List<Student> cse_students = new ArrayList<Student>();
 
        // Adding CSE students
        cse_students.add(s1);
        cse_students.add(s2);
 
        // Creating a List of EE Students
        List<Student> ee_students
            = new ArrayList<Student>();
 
        // Adding EE students
        ee_students.add(s3);
        ee_students.add(s4);
 
        // Creating objects of EE and CSE class inside
        // main()
        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);
 
        List<Department> departments = new ArrayList<Department>();
        departments.add(CSE);
        departments.add(EE);
 
        // Lastly creating an instance of Institute
        Institute institute = new Institute("BITS", departments);
 
        // Display message for better readability
        System.out.print("Total students in institute: ");
 
        // Calling method to get total number of students
        // in institute and printing on console
        System.out.print(institute.getTotalStudentsInInstitute());
    }
}
