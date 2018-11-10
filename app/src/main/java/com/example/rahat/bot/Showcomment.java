package com.example.rahat.bot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.rahat.bot.R;

import static com.example.rahat.bot.ExamActivity.mScoreBio;
import static com.example.rahat.bot.ExamActivity.mScoreChe;
import static com.example.rahat.bot.ExamActivity.mScoreMath;
import static com.example.rahat.bot.ExamActivity.mScorePhy;
import static com.example.rahat.bot.ExamActivity.wronganswer;

public class Showcomment extends AppCompatActivity {
    TextView right,wrong,total,comment;
    Button exp;
    public static int total_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_showcomment);
        right=(TextView)findViewById(R.id.right);
        wrong=(TextView)findViewById(R.id.wrong);
        total=(TextView)findViewById(R.id.total);
        comment=(TextView)findViewById(R.id.comment);
        exp=(Button)findViewById(R.id.explaination);
        total_number=mScoreBio+mScoreMath+mScorePhy+mScoreChe;
        double dd= total_number-wronganswer/4;
        right.setText("Right Answer "+Integer.toString(total_number));
        String p=Double.toString(dd);
        total.setText("Total Marks"+p);
        wrong.setText("Wrong Answer "+Integer.toString(wronganswer));
        if(mScorePhy<15 && mScoreChe<15 && mScoreMath<15 && mScoreBio<15)
        {
            comment.setText("you should work hard");
        }
        else if(mScoreChe<15)
        {
            comment.setText("Your Chemistry marks dont up to for Engineering Faculty");
        }
        else if(mScorePhy<15)
        {
            comment.setText("Your Physics marks dont up to for Engineering Faculty");
        }
        else if(mScoreMath<15)
        {
            comment.setText("Your Mathemetics marks dont up to for Engineering Faculty");
        }
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(Showcomment.this,Explaination.class);
                startActivity(p);
            }
        });
    }
}
