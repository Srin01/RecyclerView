package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity
{
    private EditText name;
    private EditText marks1;
    private EditText marks2;
    private EditText marks3;

    public static final String NAME_KEY = "name";
    public static final String MARKS1_KEY = "marks1";
    public static final String MARKS2_KEY = "marks2";
    public static final String MARKS3_KEY = "marks3";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        bindViews();
    }

    public void addStudentDetail(View view)
    {
        String name_text = name.getText().toString();
        int marks1_nub = Integer.parseInt(marks1.getText().toString());
        int marks2_nub = Integer.parseInt(marks2.getText().toString());
        int marks3_nub = Integer.parseInt(marks3.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(NAME_KEY, name_text);
        intent.putExtra(MARKS1_KEY, marks1_nub);
        intent.putExtra(MARKS2_KEY, marks2_nub);
        intent.putExtra(MARKS3_KEY, marks3_nub);

        setResult(RESULT_OK,intent);
        finish();
    }

    private void bindViews()
    {
        name = findViewById(R.id.editText_name);
        marks1 = findViewById(R.id.editText_marks1);
        marks2 = findViewById(R.id.editText_marks2);
        marks3 = findViewById(R.id.editText_marks3);
    }
}