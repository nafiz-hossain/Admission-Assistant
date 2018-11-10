package com.example.rahat.bot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notify extends AppCompatActivity {

    private Button mdubutton ;
    private Button mjubutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);
        mdubutton= (Button) findViewById(R.id.duwebsitebutton);
        mjubutton=(Button)findViewById(R.id.juwebsitebutton);
        mdubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://admission.eis.du.ac.bd/"));
                startActivity(intent);
            }
        });
      mjubutton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://ju-admission.org/"));
              startActivity(intent);
          }
      });
    }
}
