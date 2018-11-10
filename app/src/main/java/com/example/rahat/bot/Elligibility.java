package com.example.rahat.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahat.bot.R;

public class Elligibility extends AppCompatActivity {
    double banglagrade,englishgrade,mathgrade,physicsgrade,chemgrade,biologygrade,sscgpa,hscgpa;
    double defaultValue=0.00;
    TextView mdustatus ;
    TextView mjustatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elligibility);
        mdustatus=(TextView)findViewById(R.id.dustatus);
        mjustatus=(TextView)findViewById(R.id.justatus);

        Intent receiveIntent = this.getIntent();
        banglagrade = receiveIntent.getDoubleExtra("banglagrade", defaultValue);
        englishgrade = receiveIntent.getDoubleExtra("englishgrade", defaultValue);
        mathgrade = receiveIntent.getDoubleExtra("mathgrade", defaultValue);
        physicsgrade = receiveIntent.getDoubleExtra("physicsgrade", defaultValue);
        chemgrade = receiveIntent.getDoubleExtra("chemestrygrade",defaultValue);
        biologygrade=receiveIntent.getDoubleExtra("biologygrade",defaultValue);
        sscgpa=receiveIntent.getDoubleExtra("sscgpa",defaultValue);
        hscgpa=receiveIntent.getDoubleExtra("hscgpa",defaultValue);




        setdustatus();
        setjustatus();


        Toast.makeText(this,"See the Result", Toast.LENGTH_LONG).show();



    }

    private void setjustatus() {
        String status="";
        if(sscgpa>=3.5&&hscgpa>=3.5) {
            if (sscgpa + hscgpa >= 7.5) status += "A";
            if (sscgpa + hscgpa >= 8) status += " D H";
            mjustatus.setText(status);
        }

    }

    private void setdustatus() {

        if(sscgpa+hscgpa>=8)
        if(banglagrade>=3.5&&englishgrade>=3.5&&mathgrade>=3.5&&physicsgrade>=3.5&&chemgrade>=3.5&&biologygrade>=3.5)
            mdustatus.setText("Yes");
    }
}
