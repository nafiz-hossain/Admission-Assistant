package com.example.rahat.bot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {
    private EditText mnamefield;
    private EditText memailfield;
    private EditText mpasswordfield,mConfirmPass;;
    private Button mbutton,already_userbtn;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        mAuth = FirebaseAuth.getInstance();

        mnamefield =(EditText)findViewById(R.id.nameinput);
        memailfield = (EditText)findViewById(R.id.emailinput);
        mpasswordfield=(EditText)findViewById(R.id.passwordinput);
        mConfirmPass = (EditText) findViewById(R.id.confirmPassword_txt);
        mbutton= (Button) findViewById(R.id.submitbutton);
        already_userbtn= (Button) findViewById(R.id.already_user);
        mProgress =new ProgressDialog(this);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startregistar();
            }
        });

        already_userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainintent2 = new Intent(CreateAccount.this,LoginActivity.class);
                mainintent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainintent2);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(CreateAccount.this,"Back Pressed", Toast.LENGTH_SHORT).show();


        Intent mainintent3 = new Intent(CreateAccount.this,Home.class);
        mainintent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainintent3);
    }
    private void startregistar() {
        final String name = mnamefield.getText().toString().trim();
        String email = memailfield.getText().toString();
        String password =mpasswordfield.getText().toString();
        mProgress.setMessage("Creating Your Account..");
        mProgress.show();

       if(!password.equals(mConfirmPass.getText().toString()))
        {
            mConfirmPass.setError("Password does not match");

            return;
        }

        else if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password) ){

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        final FirebaseUser myuser = mAuth.getCurrentUser();

                        String user_id = mAuth.getCurrentUser().getUid();
                        DatabaseReference current_user_db = mdatabase.child(user_id);
                        current_user_db.child("Name").setValue(name);
                        current_user_db.child("Image").setValue("default");
                        mProgress.dismiss();
                         Toast.makeText(CreateAccount.this,"New Account Created", Toast.LENGTH_SHORT).show();

                        if(myuser!=null)
                        {
                            //mProgress.setMessage("Signing Up..");
                            //mProgress.show();
                            // go to news feed with user profile information
                            Intent intent = new Intent(CreateAccount.this,Home.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            //
                            return;
                        }
                    }
                }
            });
        }

    }
}
