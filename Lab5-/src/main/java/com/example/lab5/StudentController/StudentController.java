package com.example.lab5.StudentController;

import com.example.lab5.ApiResponse.ApiResponse;
import com.example.lab5.Student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Student")
public class StudentController {
    ArrayList<Student> students = new ArrayList();

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added");
    }

    @GetMapping("/displayAllStudent")
    public ArrayList<Student> displayAllStudent(){
        return students;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student, @PathVariable int index){
        students.set(index,student);
        return new ApiResponse("Student updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse Delete(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student deleted");
    }

    @GetMapping("/honors/{index}")
    public ApiResponse honorsCategory(@PathVariable int index){


        if (students.get(index).getGPA() >= 4.5){
            return new ApiResponse("First class Honors");
        }else if (students.get(index).getGPA() >= 4.25 && students.get(index).getGPA() <= 4.5){
            return new ApiResponse("Second class Honors");
        }
        return new ApiResponse("No class Honors");
    }

    @GetMapping("/graterAverage")
    public ArrayList<Student> graterAverage(){
        ArrayList<Student> greaterAvg = new ArrayList();
        double average = 0;
        for(Student student : students){
            average = average + student.getGPA();
        }
        average /= students.size();
        for(Student student : students){
            if(student.getGPA() > average){
                greaterAvg.add(student);
            }
        }
        return greaterAvg;
    }




}

