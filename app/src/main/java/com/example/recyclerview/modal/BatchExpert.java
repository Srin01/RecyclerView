package com.example.recyclerview.modal;

import java.util.ArrayList;

public class BatchExpert
{
    ArrayList<Student> studentList = new ArrayList<>();

    public int getStudentCount()
    {
        return studentList.size();
    }

    public String getStudentName(int index)
    {
        return studentList.get(index).getName();
    }

    public int getStudentAverage(int index)
    {
        return studentList.get(index).getAvg();
    }

    public void AddStudent(Student s)
    {
        studentList.add(s);
    }
}
