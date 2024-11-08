package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = getIntent().getIntExtra("SCORE", 0);
        int total = getIntent().getIntExtra("TOTAL", 0);
        String category = getIntent().getStringExtra("CATEGORY");

        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(String.format("You scored %d out of %d in %s",
                score, total, category));

        // Save score to SharedPreferences
        saveScore(score, category);

        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    private void saveScore(int score, String category) {
        SharedPreferences prefs = getSharedPreferences("QuizScores", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Save only if it's a new high score
        int currentHighScore = prefs.getInt(category, 0);
        if (score > currentHighScore) {
            editor.putInt(category, score);
            editor.apply();
        }
    }
}