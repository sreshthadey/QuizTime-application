package com.example.quiztime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdit;
    ProgressBar progressBar;
    Button submitButton;
    ArrayList<QuestionModel> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionCountLabel = findViewById(R.id.noQuestion);
        questionLabel = findViewById(R.id.question);
        scoreLabel = findViewById(R.id.score);

        answerEdit = findViewById(R.id.answer);
        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);
        questionModelArraylist = new ArrayList<>();

        setUpQuestion();
        setData();

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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
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

    public void checkAnswer(){

        String answerString = answerEdit.getText().toString().trim();
        if(answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer())){
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Well Done!")
                    .setContentText("Right Answer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition ++;
                            numberOfCorrectAnswer++;
                            setData();
                            answerEdit.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();

        }else{

            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    .setContentText("The right answer is : "+questionModelArraylist.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            currentPosition ++;
                            setData();
                            answerEdit.setText("");
                        }
                    })
                    .show();
        }

        int x = ((currentPosition+1) * 100) / questionModelArraylist.size();

        progressBar.setProgress(x);

    }

    public void setUpQuestion(){


        questionModelArraylist.add(new QuestionModel("Who developed python ? ","guido van rossum"));
        questionModelArraylist.add(new QuestionModel("Name one mutable built-in data type ? ","List"));
        questionModelArraylist.add(new QuestionModel("Name one immutable built-in data type ? ","tuple"));
        questionModelArraylist.add(new QuestionModel("Is Python case sensitive when dealing with identifiers? ","yes"));
        //questionModelArraylist.add(new QuestionModel("Whom are you angry with ? ","Phaltu Lok"));


    }

    public void setData(){


        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Question No : " + (currentPosition + 1));


        }else{


            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You have successfully completed the quiz")
                    .setContentText("Your score is : "+ numberOfCorrectAnswer + "/" + questionModelArraylist.size())
                    .setConfirmText("Restart")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            currentPosition = 0;
                            numberOfCorrectAnswer = 0;
                            progressBar.setProgress(0);
                            setData();
                        }
                    })
                    .setCancelText("Close")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            finish();
                        }
                    })
                    .show();

        }

    }
}