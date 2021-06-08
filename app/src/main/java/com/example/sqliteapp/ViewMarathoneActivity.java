package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewMarathoneActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<MarathonModelClass> marathonModelClasses = databaseHelperClass.getEmployeeList();

        if (marathonModelClasses.size() > 0){
            MarathoneAdapterClass employeadapterclass = new MarathoneAdapterClass(marathonModelClasses, ViewMarathoneActivity.this);
            recyclerView.setAdapter(employeadapterclass);
        }else {
            Toast.makeText(this, "There is no person in the database", Toast.LENGTH_SHORT).show();
        }




    }
}