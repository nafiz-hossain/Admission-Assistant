package com.example.rahat.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahat.bot.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Addquestion extends AppCompatActivity {
    TextView mquestionfield, moption1f, moption2f, moption3f, moption4f, manswerf, example;
    EditText mquestionedit, moption1edit, moption2edit, moption3edit, moption4edit, mansweredit;
    Button madd, select;
    public static int i = 0;
    String question;
    DatabaseReference mrootRef,childRef,childRef1,childRef2,childRef3,childRef4,childanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addquestion);
        mrootRef= FirebaseDatabase.getInstance().getReference("Addquestion");
        mquestionedit = (EditText) findViewById(R.id.editquestion);
        mquestionfield = (TextView) findViewById(R.id.questionkey);
        moption1f = (TextView) findViewById(R.id.option1key);
        moption1edit = (EditText) findViewById(R.id.editoption1);
        moption2f = (TextView) findViewById(R.id.option2key);
        moption2edit = (EditText) findViewById(R.id.editoption2);
        moption3f = (TextView) findViewById(R.id.option3key);
        moption3edit = (EditText) findViewById(R.id.editoption3);
        moption4f = (TextView) findViewById(R.id.option4key);
        moption4edit = (EditText) findViewById(R.id.editoption4);
        manswerf = (TextView) findViewById(R.id.answerkey);
        mansweredit = (EditText) findViewById(R.id.editanswer);
        madd = (Button) findViewById(R.id.add);
        select = (Button) findViewById(R.id.selection);
        example = (TextView) findViewById(R.id.tt);
        i++;
        madd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String keyques = mquestionfield.getText().toString();
                                        String valueques = mquestionedit.getText().toString();
                                         childRef = mrootRef.child(Integer.toString(i)).child(keyques);
                                        childRef.setValue(valueques);

                                        String keyopt1 = moption1f.getText().toString();
                                        String valueopot1 = moption1edit.getText().toString();
                                         childRef1 = mrootRef.child(Integer.toString(i)).child(keyopt1);
                                        childRef1.setValue(valueopot1);

                                        String keyopt2 = moption2f.getText().toString();
                                        String valueopot2 = moption2edit.getText().toString();
                                         childRef2 = mrootRef.child(Integer.toString(i)).child(keyopt2);
                                        childRef2.setValue(valueopot2);

                                        String keyopt3 = moption3f.getText().toString();
                                        String valueopot3 = moption3edit.getText().toString();
                                         childRef3 = mrootRef.child(Integer.toString(i)).child(keyopt3);
                                        childRef3.setValue(valueopot3);

                                        String keyopt4 = moption4f.getText().toString();
                                        String valueopot4 = moption4edit.getText().toString();
                                         childRef4 = mrootRef.child(Integer.toString(i)).child(keyopt4);
                                        childRef4.setValue(valueopot4);

                                        String keyanswer = manswerf.getText().toString();
                                        String valueanswer = mansweredit.getText().toString();
                                         childanswer = mrootRef.child(Integer.toString(i)).child(keyanswer);
                                        childanswer.setValue(valueanswer);

                                    }

                                }
        );
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ll = "";
                Toast.makeText(Addquestion.this,"your question is",Toast.LENGTH_SHORT).show();
                for(int i=1;i<=4;i++)
                    //ll=updateQuestion(1);
                Toast.makeText(Addquestion.this,"your question is"+ll,Toast.LENGTH_SHORT).show();
                Intent ii = new Intent(Addquestion.this, SelectedActivity.class);
                startActivity(ii);
            }
        });

    }
    }

