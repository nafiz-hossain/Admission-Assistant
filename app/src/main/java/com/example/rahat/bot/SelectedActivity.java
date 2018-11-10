package com.example.rahat.bot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rahat.bot.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectedActivity extends AppCompatActivity {
    public static int j;
    RadioGroup group;
    public static String question;
    Button button1;
    String array[]=new String[11];
DatabaseReference mRootref,mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);


        button1=(Button)findViewById(R.id.check);

        //for(j=1;j<4;j++)
            updateQuestion(1);

    }
    public void updateQuestion(int i1)
    {
        mRootref= FirebaseDatabase.getInstance().getReference("Addquestion");
        mm=mRootref.child(Integer.toString(j));


        mm.child("Question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String ss=dataSnapshot.getValue().toString();
                //button1=new CheckBox();
                button1.setText(ss);
                //bb1.setText(ss);
                //mQuestion.setText(ss);
                Toast.makeText(SelectedActivity.this,ss,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        //String ss[0]=question;
//        array[i1]="kkk";
//        Toast.makeText(SelectedActivity.this,"question isssss"+array[i1]+" "+i1,Toast.LENGTH_SHORT).show();
//        button1=new CheckBox(this);
//        button1.setText(array[i1]);
//        group.addView(button1);
    }
}
