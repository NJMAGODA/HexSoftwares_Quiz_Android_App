package com.example.quizapp;

import java.util.HashMap;
import java.util.Map;

public class QuizDatabase {
    private static final Map<String, Question[]> questions = new HashMap<>();

    static {
        // South African History Questions
        questions.put("History", new Question[] {
                new Question(
                        "Who was the first democratically elected president of South Africa?",
                        new String[]{
                                "Nelson Mandela",
                                "Thabo Mbeki",
                                "F.W. de Klerk",
                                "Jacob Zuma"
                        },
                        "Nelson Mandela"
                ),
                new Question(
                        "In which year did South Africa become a democratic nation with the end of apartheid?",
                        new String[]{
                                "1994",
                                "1990",
                                "1992",
                                "1996"
                        },
                        "1994"
                ),
                new Question(
                        "What was the name of the island where Nelson Mandela was imprisoned for 18 years?",
                        new String[]{
                                "Robben Island",
                                "Ellis Island",
                                "Alcatraz Island",
                                "Angel Island"
                        },
                        "Robben Island"
                )
        });

        // Science Questions
        questions.put("Science", new Question[] {
                new Question(
                        "What is the closest planet to the Sun?",
                        new String[]{
                                "Mercury",
                                "Venus",
                                "Mars",
                                "Earth"
                        },
                        "Mercury"
                ),
                new Question(
                        "Which of these is not a state of matter?",
                        new String[]{
                                "Energy",
                                "Solid",
                                "Liquid",
                                "Gas"
                        },
                        "Energy"
                ),
                new Question(
                        "What is the hardest natural substance on Earth?",
                        new String[]{
                                "Diamond",
                                "Gold",
                                "Iron",
                                "Platinum"
                        },
                        "Diamond"
                )
        });

        // Sports Questions
        questions.put("Sports", new Question[] {
                new Question(
                        "Which sport is known as the 'beautiful game'?",
                        new String[]{
                                "Football/Soccer",
                                "Basketball",
                                "Rugby",
                                "Cricket"
                        },
                        "Football/Soccer"
                ),
                new Question(
                        "What national team won the 2019 Rugby World Cup?",
                        new String[]{
                                "South Africa",
                                "New Zealand",
                                "England",
                                "Australia"
                        },
                        "South Africa"
                ),
                new Question(
                        "In which sport would you perform a 'slam dunk'?",
                        new String[]{
                                "Basketball",
                                "Volleyball",
                                "Tennis",
                                "Baseball"
                        },
                        "Basketball"
                )
        });

        // Music Questions
        questions.put("Music", new Question[] {
                new Question(
                        "Which instrument is known as the 'King of Instruments'?",
                        new String[]{
                                "Pipe Organ",
                                "Piano",
                                "Violin",
                                "Guitar"
                        },
                        "Pipe Organ"
                ),
                new Question(
                        "How many lines are there in a musical staff?",
                        new String[]{
                                "5",
                                "4",
                                "6",
                                "7"
                        },
                        "5"
                ),
                new Question(
                        "What is the national anthem of South Africa called?",
                        new String[]{
                                "Nkosi Sikelel' iAfrika",
                                "God Save the King",
                                "Advance Australia Fair",
                                "The Star-Spangled Banner"
                        },
                        "Nkosi Sikelel' iAfrika"
                )
        });

        // Geography Questions
        questions.put("Geography", new Question[] {
                new Question(
                        "What is the capital city of South Africa?",
                        new String[]{
                                "Pretoria (Executive)",
                                "Cape Town",
                                "Johannesburg",
                                "Durban"
                        },
                        "Pretoria (Executive)"
                ),
                new Question(
                        "Which is the longest river in the world?",
                        new String[]{
                                "Nile River",
                                "Amazon River",
                                "Mississippi River",
                                "Yangtze River"
                        },
                        "Nile River"
                ),
                new Question(
                        "Which desert is the largest in the world?",
                        new String[]{
                                "Sahara Desert",
                                "Arabian Desert",
                                "Gobi Desert",
                                "Antarctic Desert"
                        },
                        "Antarctic Desert"
                )
        });
    }

    public static Question[] getQuestions(String category) {
        return questions.get(category);
    }
}
