package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView categoryListView;
    private List<String> categories = Arrays.asList(
            "History", "Science", "Sports", "Music", "Geography"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryListView = findViewById(R.id.categoryListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        );
        categoryListView.setAdapter(adapter);

        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = categories.get(position);
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("CATEGORY", selectedCategory);
            startActivity(intent);
        });
    }
}