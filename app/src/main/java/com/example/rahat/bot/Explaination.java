package com.example.rahat.bot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.rahat.bot.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Explaination extends AppCompatActivity {
    TextView opt1,opt2,opt3,opt4,ques,ans,showQuestionNumber;
    Button next,prev;
    private DatabaseReference mChoice1Ref,mm;
    public static int mQuestionNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_explaination);
        opt1=(TextView)findViewById(R.id.ans1);
        opt2=(TextView)findViewById(R.id.ans2);
        opt3=(TextView)findViewById(R.id.ans3);
        opt4=(TextView)findViewById(R.id.ans4);
        ans=(TextView)findViewById(R.id.ans);
        ques=(TextView)findViewById(R.id.ques);
        next=(Button)findViewById(R.id.nxt);
        prev=(Button)findViewById(R.id.prv);
        showQuestionNumber=(TextView)findViewById(R.id.showQnumber);
        showQuestionNumber.setText("Question:"+1+"/"+"20");
        updateQuestion(mQuestionNumber);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mQuestionNumber++;
                updateQuestion(mQuestionNumber);

                if(mQuestionNumber>19 )
                {
                    mQuestionNumber=20;

                }

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mQuestionNumber--;
                updateQuestion(mQuestionNumber);
                if(mQuestionNumber<0)mQuestionNumber=-1;

            }
        });

    }
    public void updateQuestion(int Number) {

        if (Number <= 0) {
            showQuestionNumber.setText("Question:" + 0 + "/" + "20");

            //Number=0;
        } else if (Number >= 19) {
            showQuestionNumber.setText("Question:" + 19 + "/" + "20");

            //Number=19;
        } else showQuestionNumber.setText("Question:" + mQuestionNumber + "/" + "20");
        DatabaseReference mdatabase = FirebaseDatabase.getInstance().getReference("QuestionsYear");
        mm = mdatabase.child(Integer.toString(mQuestionNumber));


        mm.child("question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss = dataSnapshot.getValue().toString();
                //bb1.setText(ss);
                ques.setText(ss);
                //Toast.makeText(ExamActivity.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mChoice1Ref = mdatabase.child(Integer.toString(mQuestionNumber));

        mChoice1Ref.child("choice1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss = dataSnapshot.getValue().toString();
                //bb1.setText(ss);
                opt1.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss = dataSnapshot.getValue().toString();

                opt2.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss = dataSnapshot.getValue().toString();

                opt3.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("choice4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss = dataSnapshot.getValue().toString();

                opt4.setText(ss);
                //Toast.makeText(MainActivity_splash.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mm.child("answer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mAnswer = dataSnapshot.getValue().toString();
                ans.setText(mAnswer);
                //Toast.makeText(ExamActivity.this,"Answer"+mAnswer,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }
