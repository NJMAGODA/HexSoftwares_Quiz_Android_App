package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private RadioGroup answersGroup;
    private Button submitButton;
    private Button nextButton;

    private Question[] currentQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        category = getIntent().getStringExtra("CATEGORY");

        questionText = findViewById(R.id.questionText);
        answersGroup = findViewById(R.id.answersGroup);
        submitButton = findViewById(R.id.submitButton);
        nextButton = findViewById(R.id.nextButton);

        currentQuestions = QuizDatabase.getQuestions(category);
        displayQuestion();

        submitButton.setOnClickListener(v -> checkAnswer());
        nextButton.setOnClickListener(v -> showNextQuestion());
    }

    private void displayQuestion() {
        Question question = currentQuestions[currentQuestionIndex];
        questionText.setText(question.getQuestion());
        answersGroup.removeAllViews();

        for (String answer : question.getAnswers()) {
            RadioButton button = new RadioButton(this);
            button.setText(answer);
            answersGroup.addView(button);
        }

        nextButton.setVisibility(View.GONE);
        submitButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer() {
        int selectedId = answersGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedButton = findViewById(selectedId);
        String selectedAnswer = selectedButton.getText().toString();

        if (selectedAnswer.equals(currentQuestions[currentQuestionIndex].getCorrectAnswer())) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong! Correct answer: " +
                            currentQuestions[currentQuestionIndex].getCorrectAnswer(),
                    Toast.LENGTH_SHORT).show();
        }

        submitButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.VISIBLE);
    }

    private void showNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < currentQuestions.length) {
            displayQuestion();
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("SCORE", score);
            intent.putExtra("TOTAL", currentQuestions.length);
            intent.putExtra("CATEGORY", category);
            startActivity(intent);
            finish();
        }
    }
}