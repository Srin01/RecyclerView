package com.example.recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.adapter.BatchAdapter;
import com.example.recyclerview.modal.BatchExpert;
import com.example.recyclerview.modal.Student;

public class MainActivity extends AppCompatActivity
{
    private final int ADD_STUDENT = 1234;
    BatchExpert batchExpert = new BatchExpert();
    BatchAdapter batchAdapter;
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        SetupInitializer();
    }

    private void bindViews()
    {
        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);
    }

    private void SetupInitializer()
    {
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        batchAdapter = new BatchAdapter(this, batchExpert);
        recyclerView.setAdapter(batchAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_STUDENT)
        {
            if(resultCode == RESULT_OK)
            {
                handleResultfromAddStudentActiity(data);
            }
        }


        return;
    }

    public void addStudentDetail(View view)
    {
        Intent intent = new Intent(this, AddStudentActivity.class);
        startActivityForResult(intent, ADD_STUDENT);
    }

    private  void handleResultfromAddStudentActiity(Intent data)
    {
        assert data != null;
        String name = data.getStringExtra(AddStudentActivity.NAME_KEY);
        int marks1 = data.getIntExtra(AddStudentActivity.MARKS1_KEY, 100);
        int marks2 = data.getIntExtra(AddStudentActivity.MARKS2_KEY, 100);
        int marks3 = data.getIntExtra(AddStudentActivity.MARKS3_KEY, 100);

        Student student = new Student(name, marks1, marks2, marks3);
        batchExpert.AddStudent(student);
        batchAdapter.notifyDataSetChanged();
    }
}