package com.example.rahat.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rahat.bot.Home;
import com.example.rahat.bot.R;

//import com.myscheduler.R;
//import com.example.fivefinger.R;

public class MainActivity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_splash);
        final ProgressBar ProjectBar = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);

        ProjectBar.setVisibility(View.INVISIBLE);
        //Setting up the toolbar
        Toolbar toolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        Button btn= (Button)findViewById(R.id.buttonsub);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=10;i<100;i++)
                {
                   // ProjectBar.setPadding(i,i,i,i);
                    ProjectBar.setProgress(i);
                    ProjectBar.setVisibility(View.VISIBLE);

                }

                startActivity(new Intent(MainActivity_splash.this, WelcomeActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
