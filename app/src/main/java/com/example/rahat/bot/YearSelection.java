package com.example.rahat.bot;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rahat.bot.R;

public class YearSelection extends Activity  implements AlertSubject.AlertPositiveListener {
    int position=0;
    Button button_16,button_17,button_15,button_14,button_13,button_12,button_11,button_10,button_9,button_8,button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_selection);
        button_add=(Button) findViewById(R.id.y16);
        button_17=(Button) findViewById(R.id.y17);



        if(!isOnline())
            builddialogue(YearSelection.this).show();
        else{}
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(YearSelection.this,Addquestion.class);
                startActivity(i);
            }
        });
        button_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getFragmentManager();

                /** Instantiating the DialogFragment class */
                AlertSubject alert = new AlertSubject();

                /** Creating a bundle object to store the selected item's index */
                Bundle b  = new Bundle();

                /** Storing the selected item's index in the bundle object */
                b.putInt("position", position);

                /** Setting the bundle object to the dialog fragment object */
                alert.setArguments(b);

                /** Creating the dialog fragment object, which will in turn open the alert dialog window */
                alert.show(manager, "alert_dialog_radio");
            }
        });


    }
    @Override
    public void onPositiveClick(int position) {
        this.position = position;
        Toast.makeText(YearSelection.this,"your position "+position,Toast.LENGTH_SHORT).show();
        if(position==0)
        {
            Intent ip=new Intent(YearSelection.this,ExamActivity.class);
            startActivity(ip);
        }

        /** Getting the reference of the textview from the main layout */
        //TextView tv = (TextView) findViewById(R.id.tv_android);

        /** Setting the selected android version in the textview */
        //tv.setText("Your Choice : " + Options.code[this.position]);
    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(YearSelection.this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public AlertDialog.Builder builddialogue(Context c)
    {
        final AlertDialog.Builder builder=new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have mobile data or wifi to access this.Press Ok to exit.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                YearSelection.this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
        return builder;

    }
}
