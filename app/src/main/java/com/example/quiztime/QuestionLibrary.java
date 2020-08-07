package com.example.quiztime;

public class QuestionLibrary {

    private String questions[] = {
            "The format identifier ‘%i’ is also used for _____ data type.?",
            " Which of the data types has the size that is variable?",
            "enum types are processed by _________.",
            "Which of the following declaration is not supported by C?"
    };

    private String answers[][] = {
            {"char", "int", "double","float"},
            {"struct", "char", "int","float"},
            {"Compiler", "Preprocessor", "Linker","None of these"},
            {"char *str", "float str = 3e2", "String str","None of these"}
    };

    private String correctAnswer[] = {"int", "struct", "Compiler", "String str"};

    public String getQuestion(int a){
        String mQuestion = questions[a];
        return mQuestion;
    }

    public String getChoice1(int a){
        String mAnswer = answers[a][0];
        return mAnswer;
    }
    public String getChoice2(int a){
        String mAnswer = answers[a][1];
        return mAnswer;
    }
    public String getChoice3(int a){
        String mAnswer = answers[a][2];
        return mAnswer;
    }
    public String getChoice4(int a){
        String mAnswer = answers[a][3];
        return mAnswer;
    }
    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
    public int getLength(){
        return questions.length;
    }
}
