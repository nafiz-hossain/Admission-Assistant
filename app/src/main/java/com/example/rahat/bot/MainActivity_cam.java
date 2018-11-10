package com.example.rahat.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rahat.bot.R;

public class MainActivity_cam extends  AppCompatActivity {

    private TextView mBangla ;
    private TextView mEnglish ;
    private TextView mMath ;
    private TextView mPhysics ;
    private TextView mChemestry ;
    private TextView mBiology ;

    private EditText mbanglainput;
    private EditText menglishinput;
    private EditText mmathinput;
    private EditText mphysicsinput;
    private EditText mcheminput;
    private EditText mbiologyinput;
    private EditText msscgpainput;
    private EditText mhscgpainput;

    private Button msubmitbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cam2);
        mBangla =(TextView)findViewById(R.id.bangla);
        mEnglish =(TextView)findViewById(R.id.english);
        mMath =(TextView)findViewById(R.id.math);
        mPhysics =(TextView)findViewById(R.id.physics);
        mChemestry =(TextView)findViewById(R.id.chemestry);
        mBiology =(TextView)findViewById(R.id.biology);

        mbanglainput=(EditText)findViewById(R.id.banglainput);
        menglishinput=(EditText)findViewById(R.id.englishinput);
        mmathinput=(EditText)findViewById(R.id.mathinput);
        mphysicsinput=(EditText)findViewById(R.id.physicsinput);
        mcheminput=(EditText)findViewById(R.id.chemestryinput);
        mbiologyinput=(EditText)findViewById(R.id.biologyinput);
        msscgpainput=(EditText)findViewById(R.id.sscgpainput);
        mhscgpainput= (EditText) findViewById(R.id.hscgpainput);


        msubmitbutton=(Button)findViewById(R.id.Submitbutton);

        msubmitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent elligibilityintent = new Intent(MainActivity_cam.this,Elligibility.class);
                elligibilityintent.putExtra("banglagrade",Double.parseDouble(mbanglainput.getText().toString()));
                elligibilityintent.putExtra("englishgrade",Double.parseDouble(menglishinput.getText().toString()));
                elligibilityintent.putExtra("mathgrade",Double.parseDouble(mmathinput.getText().toString()));
                elligibilityintent.putExtra("physicsgrade",Double.parseDouble(mphysicsinput.getText().toString()));
                elligibilityintent.putExtra("chemestrygrade",Double.parseDouble(mcheminput.getText().toString()));
                elligibilityintent.putExtra("biologygrade",Double.parseDouble(mbiologyinput.getText().toString()));
                elligibilityintent.putExtra("sscgpa",Double.parseDouble(msscgpainput.getText().toString()));
                elligibilityintent.putExtra("hscgpa",Double.parseDouble(mhscgpainput.getText().toString()));
                startActivity(elligibilityintent);
            }
        });

    }
}
