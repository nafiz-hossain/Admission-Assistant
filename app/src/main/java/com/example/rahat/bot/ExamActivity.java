package com.example.rahat.bot;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahat.bot.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExamActivity extends AppCompatActivity {
    Intent ii;
    private CountDownTimer countDownTimer; // built in android class
    // CountDownTimer
    private long totalTimeCountInMilliseconds; // total count down time in
    // milliseconds
    private long timeBlinkInMilliseconds; // start time of start blinking
    private boolean blink; // controls the blinking .. on and off
    private TextView mScoreView,textViewShowTime;
    private TextView mQuestion,showQuestionNumber;
    private Button mButtonChoice1,mButtonChoice2,mButtonChoice3,mButtonChoice4,prevbutton,nextbutton,xtbutton;
    public static int mScorePhy=0,mScoreChe=0,mScoreBio=0,mScoreMath=0,wronganswer=0;
    private int i=0;
    static boolean bb=false;
    private static int mQuestionNumber=0;
    private int[]marksarray=new int[20];
    private String mAnswer;
    private DatabaseReference mQuestionRef,mChoice1Ref,mChice2Ref,mChoice3Ref,mChoice4Ref,mAnswerref;
    private DatabaseReference mdatabase,mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        textViewShowTime = (TextView) findViewById(R.id.tvTimeCount);
        textViewShowTime.setText("");
        setTimer();
        startTimer();
        for(i=0;i<20;i++) marksarray[i]=0;
//        bb1=(Button)findViewById(R.id.btn);
        mScoreView = (TextView) findViewById(R.id.num);
        mQuestion = (TextView) findViewById(R.id.ques);
        mButtonChoice1 = (Button) findViewById(R.id.ans1);
        mButtonChoice2 = (Button) findViewById(R.id.ans2);
        mButtonChoice3 = (Button) findViewById(R.id.ans3);
        mButtonChoice4 = (Button) findViewById(R.id.ans4);
        prevbutton=(Button) findViewById(R.id.qt);
        showQuestionNumber=(TextView) findViewById(R.id.showQnumber);
        nextbutton=(Button) findViewById(R.id.nxt);
        xtbutton=(Button) findViewById(R.id.xt);
        updateQuestion(mQuestionNumber);
        //showQuestionNumber.setText("Question:"+1+"/"+"20");
        xtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(ExamActivity.this);
                builder.setMessage("Are you sure to exit?");
                builder.setCancelable(true);
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });
        mButtonChoice1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {


                if((mButtonChoice1.getText().equals(mAnswer)) && (marksarray[mQuestionNumber]==0))
                {

                    if(mQuestionNumber<=19)
                    {
                        mScorePhy=mScorePhy+1;
                        updateScore(mScorePhy);
                    }
                    else if(mQuestionNumber>19 && mQuestionNumber<=39)
                    {
                        mScoreChe=mScoreChe+1;
                        updateScore(mScoreChe);
                    }
                    else if(mQuestionNumber>39 && mQuestionNumber<=59)
                    {
                        mScoreBio=mScoreBio+1;
                        updateScore(mScoreBio);
                    }
                    else if(mQuestionNumber>59 && mQuestionNumber<=79)
                    {
                        mScoreMath=mScoreMath+1;
                        updateScore(mScoreMath);
                    }

                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;

                    Toast.makeText(ExamActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else

                {
                    wronganswer++;
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"False",Toast.LENGTH_SHORT).show();
                }
            }

        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                if((mButtonChoice2.getText().equals(mAnswer))&&(marksarray[mQuestionNumber]==0))
                {
                    if(mQuestionNumber<=19)
                    {
                        mScorePhy=mScorePhy+1;
                        updateScore(mScorePhy);
                    }
                    else if(mQuestionNumber>19 && mQuestionNumber<=39)
                    {
                        mScoreChe=mScoreChe+1;
                        updateScore(mScoreChe);
                    }
                    else if(mQuestionNumber>39 && mQuestionNumber<=59)
                    {
                        mScoreBio=mScoreBio+1;
                        updateScore(mScoreBio);
                    }
                    else if(mQuestionNumber>59 && mQuestionNumber<=79) {
                        mScoreMath = mScoreMath + 1;
                        updateScore(mScoreMath);
                    }

                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    wronganswer++;
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"False",Toast.LENGTH_SHORT).show();
                }

            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                if((mButtonChoice3.getText().equals(mAnswer))&&(marksarray[mQuestionNumber]==0))
                {
                    if(mQuestionNumber<=19)
                    {
                        mScorePhy=mScorePhy+1;
                        updateScore(mScorePhy);
                    }
                    else if(mQuestionNumber>19 && mQuestionNumber<=39)
                    {
                        mScoreChe=mScoreChe+1;
                        updateScore(mScoreChe);
                    }
                    else if(mQuestionNumber>39 && mQuestionNumber<=59)
                    {
                        mScoreBio=mScoreBio+1;
                        updateScore(mScoreBio);
                    }
                    else if(mQuestionNumber>59 && mQuestionNumber<=79) {
                        mScoreMath = mScoreMath + 1;
                        updateScore(mScoreMath);
                    }
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    wronganswer++;
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"False",Toast.LENGTH_SHORT).show();
                }

            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

                if((mButtonChoice4.getText().equals(mAnswer))&&(marksarray[mQuestionNumber]==0))
                {
                    if(mQuestionNumber<=19)
                    {
                        mScorePhy=mScorePhy+1;
                        updateScore(mScorePhy);
                    }
                    else if(mQuestionNumber>19 && mQuestionNumber<=39)
                    {
                        mScoreChe=mScoreChe+1;
                        updateScore(mScoreChe);
                    }
                    else if(mQuestionNumber>39 && mQuestionNumber<=59)
                    {
                        mScoreBio=mScoreBio+1;
                        updateScore(mScoreBio);
                    }
                    else if(mQuestionNumber>59 && mQuestionNumber<=79) {
                        mScoreMath = mScoreMath + 1;
                        updateScore(mScoreMath);
                    }
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    wronganswer++;
                    updateQuestion(mQuestionNumber);
                    marksarray[mQuestionNumber]=1;
                    Toast.makeText(ExamActivity.this,"False",Toast.LENGTH_SHORT).show();
                }

            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mQuestionNumber++;
                updateQuestion(mQuestionNumber);

                if(mQuestionNumber==19 )
                {
                    mQuestionNumber=20;
                    ii=new Intent(ExamActivity.this,Showcomment.class);
                    startActivity(ii);
                }

            }
        });
        prevbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mQuestionNumber--;
                updateQuestion(mQuestionNumber);
                if(mQuestionNumber<=1)mQuestionNumber=1;

            }
        });
    }
    public void setTimer()
    {
        int time=20;
        totalTimeCountInMilliseconds = 60 * time * 1000;
        timeBlinkInMilliseconds = 30 * 1000;
    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 500) {

            // 500 means, onTick function will be called at every 500
            // milliseconds
            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;

                if (leftTimeInMilliseconds < timeBlinkInMilliseconds) {
                    textViewShowTime.setText("");
                    // change the style of the textview .. giving a red
                    // alert style
                    if (blink) {
                        textViewShowTime.setVisibility(View.VISIBLE);
                        // if blink is true, textview will be visible
                    } else {
                        textViewShowTime.setVisibility(View.INVISIBLE);
                    }

                    blink = !blink; // toggle the value of blink
                }

                textViewShowTime.setText("Remaining" + String.format("%02d:%02d:%02d", seconds / 3600,
                        (seconds % 3600) / 60, (seconds % 60)));
                // format the textview to show the easily readable format

            }

            public void onFinish() {
                // this function will be called when the timecount is finished
                textViewShowTime.setText("Time up!");
               // ii=new Intent(ExamActivity.this,Showcomment.class);
                startActivity(ii);

                textViewShowTime.setVisibility(View.VISIBLE);



            }

        }.start();
    }
    private void updateScore(int point)
    {
        mScoreView.setText(""+mScorePhy);

    }

    public void updateQuestion(int Number) {


        if(Number<=0)
        {
            //showQuestionNumber.setText("Question:"+0+"/"+"20");

            //Number=0;
        }
        else if(Number>=19)
        {
            //showQuestionNumber.setText("Question:"+19+"/"+"20");
            ///startActivity(ii);
            //Number=19;
        }
         showQuestionNumber.setText("Question:"+(mQuestionNumber+1)+"/"+"20");
        mdatabase= FirebaseDatabase.getInstance().getReference("QuestionsYear");
        mm=mdatabase.child(Integer.toString(mQuestionNumber));


        mm.child("question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();

                mQuestion.setText(ss);
                Toast.makeText(ExamActivity.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mChoice1Ref=mdatabase.child(Integer.toString(mQuestionNumber));

        mChoice1Ref.child("choice1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();
                //bb1.setText(ss);
                mButtonChoice1.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();

                mButtonChoice2.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();

                mButtonChoice3.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();

                mButtonChoice4.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("answer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer=dataSnapshot.getValue().toString();
                Toast.makeText(ExamActivity.this,"Answer"+mAnswer,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
