package com.example.quizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        ListView leaderboardList = findViewById(R.id.leaderboardList);
        List<Map<String, String>> leaderboardData = getLeaderboardData();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                leaderboardData,
                android.R.layout.simple_list_item_2,
                new String[]{"category", "score"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        leaderboardList.setAdapter(adapter);
    }

    private List<Map<String, String>> getLeaderboardData() {
        List<Map<String, String>> data = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("QuizScores", MODE_PRIVATE);

        String[] categories = {"History", "Science", "Sports", "Music", "Geography"};

        for (String category : categories) {
            int score = prefs.getInt(category, 0);
            Map<String, String> entry = new HashMap<>();
            entry.put("category", category);
            entry.put("score", "High Score: " + score);
            data.add(entry);
        }

        return data;
    }
}