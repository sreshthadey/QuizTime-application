package com.example.quiztime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class SecondActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    TextView questionLabel, questionCountLabel, scoreLabel;
    ProgressBar progressBar;
    Button buttonChoice1;
    Button buttonChoice2;
    Button buttonChoice3;
    Button buttonChoice4;


    String mAnswer;
    int score = 0;
    int currentPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        questionCountLabel = findViewById(R.id.noQuestion);
        progressBar = findViewById(R.id.progress);
        scoreLabel = findViewById(R.id.score);
        questionLabel = (TextView)findViewById(R.id.question);
        buttonChoice1 = (Button)findViewById(R.id.choice1);
        buttonChoice2 = (Button)findViewById(R.id.choice2);
        buttonChoice3 = (Button)findViewById(R.id.choice3);
        buttonChoice4 = (Button)findViewById(R.id.choice4);

        updateQuestion();
        updateScore(score);

        if(savedInstanceState != null){

            TextView questionNo = findViewById(R.id.noQuestion);
            TextView score = findViewById(R.id.score);
            TextView question = findViewById(R.id.question);

            String message1 = savedInstanceState.getString(keystore.KEY_QUESTION_NO);
            questionNo.setText(message1);

            String message2 = savedInstanceState.getString(keystore.KEY_SCORE);
            score.setText(message2);

            String message3 = savedInstanceState.getString(keystore.KEY_QUESTION);
            question.setText(message3);
        }

        buttonChoice1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(buttonChoice1.getText() == mAnswer){
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Well Done!")
                            .setContentText("Right Answer")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    score = score + 1;
                                    updateQuestion();
                                    updateScore(score);
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();

                }
                else{
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Wrong Answer")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismiss();
                                    updateQuestion();
                                    updateScore(score);
                                }
                            })
                            .show();
                }
            }
        });

        buttonChoice2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(buttonChoice2.getText() == mAnswer){
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Well Done!")
                            .setContentText("Right Answer")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    score = score + 1;
                                    updateQuestion();
                                    updateScore(score);
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();

                }
                else{
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Wrong Answer")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismiss();
                                    updateQuestion();
                                    updateScore(score);
                                }
                            })
                            .show();
                }
            }
        });

        buttonChoice3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(buttonChoice3.getText() == mAnswer){
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Well Done!")
                            .setContentText("Right Answer")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    score = score + 1;
                                    updateQuestion();
                                    updateScore(score);
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();

                }
                else{
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Wrong Answer")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismiss();
                                    updateQuestion();
                                    updateScore(score);
                                }
                            })
                            .show();
                }
            }
        });

        buttonChoice4.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                if(buttonChoice4.getText() == mAnswer){
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Well Done!")
                            .setContentText("Right Answer")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    score = score + 1;
                                    updateQuestion();
                                    updateScore(score);
                                    sweetAlertDialog.dismiss();
                                }
                            })
                            .show();

                }
                else{
                    new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Wrong Answer")
                            .setConfirmText("OK")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismiss();
                                    updateQuestion();
                                    updateScore(score);
                                }
                            })
                            .show();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause is called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String questionNo = ((TextView) findViewById(R.id.noQuestion)).getText().toString();
        String score = ((TextView) findViewById(R.id.score)).getText().toString();
        String question = ((TextView) findViewById(R.id.question)).getText().toString();

        if(!questionNo.equals(""))
            savedInstanceState.putString(keystore.KEY_QUESTION_NO, questionNo);

        if(!score.equals(""))
            savedInstanceState.putString(keystore.KEY_SCORE, score);

        if(!question.equals(""))
            savedInstanceState.putString(keystore.KEY_QUESTION, question);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop is called");
    }

    void updateScore(int mscore){
        scoreLabel.setText("Score :" + mscore);
    }
    void updateQuestion(){

        if(currentPosition < mQuestionLibrary.getLength()) {
            questionLabel.setText(mQuestionLibrary.getQuestion(currentPosition));
            buttonChoice1.setText(mQuestionLibrary.getChoice1(currentPosition));
            buttonChoice2.setText(mQuestionLibrary.getChoice2(currentPosition));
            buttonChoice3.setText(mQuestionLibrary.getChoice3(currentPosition));
            buttonChoice4.setText(mQuestionLibrary.getChoice4(currentPosition));
            mAnswer = mQuestionLibrary.getCorrectAnswer(currentPosition);
            questionCountLabel.setText("Question No : " + (currentPosition + 1));
            int x = ((currentPosition+1) * 100) / mQuestionLibrary.getLength();

            progressBar.setProgress(x);
            currentPosition++;
        }
        else{
            new SweetAlertDialog(SecondActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You have successfully completed the quiz")
                    .setContentText("Your score is : "+ score)
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismiss();
                        }
                    })

                    .show();
        }
    }

    public void openMainActivity(View view) {

        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}