package com.example.rahat.bot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahat.bot.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.squareup.picasso.Picasso;

public class Home extends AppCompatActivity {
    CircleMenu circleMenu;
    private FirebaseAuth mauth;
    private  FirebaseAuth.AuthStateListener myauthlistener;
    private Button buttonsignout;
    private TextView setname1;

    private static final int GALLERY_INTENT = 2;

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    private ActionBarDrawerToggle t;

    private ProgressDialog mProgress;
    private View mProgressView;

    private NavigationView nv;
    private TextView userNameTextViewNav ;
    private TextView userEmailTextViewNav;
    private ImageView profile_imageView ;

    private DatabaseReference mdatabase;
    private StorageReference mStorage;

    private ImageView profilePic;



    private FirebaseUser user;
    private ValueEventListener mUserModelListener;

    private String profilePicUrl;




    //private FirebaseUser user;
    private ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent i = new Intent(Home.this, LoginActivity.class);
            startActivity(i);

        }

        user = FirebaseAuth.getInstance().getCurrentUser();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        mdatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();

        profilePic = (ImageView) findViewById(R.id.img_profilepic);


        setSupportActionBar(toolbar);
        // User user = new User();
        String photoUrl = null;
        //setname1 = (TextView)findViewById(R.id.setname);
        //progressBar1 = (ProgressBar) findViewById(R.id.logout_progress);

          dl= (DrawerLayout) findViewById(R.id.drawer_layout);
       abdt = new ActionBarDrawerToggle(this, dl,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

         abdt.setDrawerIndicatorEnabled(true);
          dl.addDrawerListener(abdt);
         abdt.syncState();
         mauth = FirebaseAuth.getInstance();

        mProgress =new ProgressDialog(this);
        mProgressView = findViewById(R.id.logout_progress);
        Toast.makeText(Home.this, "Userrrrrrrrrrrrrrrrrrr"+user,Toast.LENGTH_SHORT).show();






        /*mauth = FirebaseAuth.getInstance();

        myauthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull final FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    setname1.setText("User");
                    Toast.makeText(Home.this,"User" + firebaseAuth.getCurrentUser() , Toast.LENGTH_SHORT).show();
                  System.out.println("My profile"+ firebaseAuth.getCurrentUser());
                    buttonsignout.setVisibility(View.VISIBLE);

                    buttonsignout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            firebaseAuth.getInstance().signOut();
                        }
                    });
                }
                else
                {
                    setname1.setText("Guest");
                    Toast.makeText(Home.this,"guest", Toast.LENGTH_SHORT).show();
                    buttonsignout.setVisibility(View.GONE);
                }
            }
        };*/


      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);












       nv = (NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.nav_my_account:
                        Toast.makeText(Home.this, "My Account",Toast.LENGTH_SHORT).show();
                        Intent intentc=new Intent(Home.this,ProfilePageActivity.class);
                        startActivity(intentc);
                        break;

                    case R.id.nav_notifications:
                        Toast.makeText(Home.this, "Notification",Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.nav_my_exams:
                        Toast.makeText(Home.this, "Year Selection",Toast.LENGTH_SHORT).show();
                            Intent intentd=new Intent(Home.this,YearSelection.class);
                            startActivity(intentd);
                            break;


                    case R.id.nav_message:
                        Toast.makeText(Home.this, "Bot",Toast.LENGTH_SHORT).show();

                                Intent intentb=new Intent(Home.this,MainActivity.class);
                                startActivity(intentb);
                    case R.id.nav_map:
                        Toast.makeText(Home.this, "Map",Toast.LENGTH_SHORT).show();

                        Intent intenta=new Intent(Home.this,MapActivity.class);
                        startActivity(intenta);

                    case R.id.nav_profile:
                        Toast.makeText(Home.this, "Profile",Toast.LENGTH_SHORT).show();

                        Intent intentaa=new Intent(Home.this,ProfilePageActivity.class);
                        startActivity(intentaa);



                    case R.id.sign_out:
                        //mauth.signOut();
                        mProgress.setMessage("Signing Out..");
                        mProgress.show();
                        FirebaseAuth.getInstance().signOut();


                        Toast.makeText(Home.this, "Sign Out",Toast.LENGTH_SHORT).show();
                        mProgress.dismiss();

                        Intent i = new Intent(Home.this, LoginActivity.class);
                        startActivity(i);

                        break;
                }
                return true;




            }
        });
        //loadNavigationDrawerHeader(nv.getHeaderView(0));


       userNameTextViewNav = nv.getHeaderView(0).findViewById(R.id.current_user_name);
        userEmailTextViewNav = nv.getHeaderView(0).findViewById(R.id.user_email);
       profile_imageView = nv.getHeaderView(0).findViewById(R.id.profile_imageView_nav);

////////////////////////
       /* if (user != null) {
            userNameTextViewNav.setText(user.getDisplayName());
            userEmailTextViewNav.setText(user.getEmail());
            Glide.with(this).load(user.getPhotoUrl()).into(profile_imageView);
            User userApp = new User();
            String photoUrl = null;
            if (user.getPhotoUrl() != null) {
                userApp.setPhotoUrl(user.getPhotoUrl().toString());
            }

            userApp.setEmail(user.getEmail());
            userApp.setUser(user.getDisplayName());
            userApp.setUid(FirebaseAuth.getInstance().getCurrentUser().getUid());
            FirebaseUtils.getUserRef(user.getEmail().replace(".", ",")).setValue(userApp);

        }
        */
        /////////////////


/*{
                    case R.id.account:
                        Intent intentc=new Intent(Home.this,ProfilePageActivity.class);
                        startActivity(intentc);
                        break;
                        //Toast.makeText(Home.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Intent intentd=new Intent(Home.this,LoginActivity.class);
                        startActivity(intentd);
                        break;
                        //Toast.makeText(Home.this, "Sign In",Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        mauth.signOut();
                        //Toast.makeText(Home.this, "Sign Out",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }


 */







        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.vaia, R.mipmap.icon_cancel);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.imageedit_1_2092279233)
                .addSubMenu(Color.parseColor("#F05A11"), R.mipmap.consistency)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.graduation)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.chatbot)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Toast.makeText(Home.this, "Info Button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent intent=new Intent(Home.this,ProfilePageActivity.class);
                                                             startActivity(intent);
                                                             break;
                                                         case 1:
                                                             Toast.makeText(Home.this, "Exam button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent intente=new Intent(Home.this,YearSelection.class);
                                                             startActivity(intente);
                                                             break;
                                                         case 2:
                                                             Toast.makeText(Home.this, "Campus button Clciked", Toast.LENGTH_SHORT).show();
                                                             Intent intentc=new Intent(Home.this,MainActivity_cam.class);
                                                             startActivity(intentc);
                                                             break;
                                                         case 3:
                                                             Toast.makeText(Home.this, "Notify button Clcked", Toast.LENGTH_SHORT).show();
                                                             Intent intentn=new Intent(Home.this,InfoActivity.class);
                                                             startActivity(intentn);
                                                             break;
                                                         case 4:
                                                             Toast.makeText(Home.this, "chatBot button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent intentb=new Intent(Home.this,MainActivity.class);
                                                             startActivity(intentb);
                                                             break;
                                                         case 5:
                                                             Toast.makeText(Home.this, "Map Button Clicked", Toast.LENGTH_SHORT).show();
                                                             Intent intentm=new Intent(Home.this,MapActivity.class);
                                                             startActivity(intentm);
                                                             break;
                                                     }
                                                 }
                                             }

        );

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {
                                                         Toast.makeText(Home.this, "Menu Opend", Toast.LENGTH_SHORT).show();
                                                     }

                                                     @Override
                                                     public void onMenuClosed() {
                                                         Toast.makeText(Home.this, "Menu Closed", Toast.LENGTH_SHORT).show();
                                                     }
                                                 }
        );
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
       else  if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();

    }


    @Override
    protected void onStart() {
        super.onStart();



        user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference mUserReference;
        String refKey = user.getUid();

        FirebaseUser currentUser = mauth.getCurrentUser();
        Toast.makeText(Home.this, "my user name is"+ currentUser, Toast.LENGTH_SHORT).show();
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        mUserReference = mdatabase.child("users").child(refKey);

        mUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile2 userProfile = dataSnapshot.getValue(UserProfile2.class);

                if(userProfile==null)
                {
                    //Toast.makeText(ProfilePageActivity.this,"You have no info to show, Edit Profile",Toast.LENGTH_SHORT).show();
                    return;
                }

                //System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX got it");

                StorageReference filePath = FirebaseStorage.getInstance().getReference()
                        .child("photos")
                        .child(user.getUid().toString())
                        .child("ProfilePic");

                filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        if(uri!=null) Picasso.with(Home.this).load(uri).fit().centerCrop().into(profile_imageView);
                    }
                });




                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    // User is signed in
                    Intent i = new Intent(Home.this, LoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                } else {
                    userNameTextViewNav.setText(userProfile.getName().toString());
                    userEmailTextViewNav.setText(userProfile.getEmail().toString());

                    // User is signed out
                    Toast.makeText(Home.this,"Signed in", Toast.LENGTH_SHORT).show();

                }

                // [END EXCLUDE]
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(Home.this, "Failed to load User Profile.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        });














    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(abdt.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_groups) {
            loadMyGroupPage();
        }
        else if (id == R.id.nav_notifications) {

        }
        else if (id == R.id.nav_settings) {

        }
        else if (id == R.id.nav_about) {
            Intent intentAbout = new Intent(MainActivity.this, About.class);
            startActivity(intentAbout);
        }
        else if (id == R.id.nav_privacy_policy) {

        }
        else if (id == R.id.nav_privacy_policy) {

        }
        else if (id == R.id.nav_share) {

        }
        else if(id==R.id.nav_message){
            Intent intent = new Intent(this, ChatListActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_about) {

        }
        else if(id==R.id.sign_out){
            FriendDB.getInstance(getApplicationContext()).dropDB();
            GroupDB.getInstance(getApplicationContext()).dropDB();
            ServiceUtils.stopServiceFriendChat(getApplicationContext().getApplicationContext(), true);
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            startActivity(new Intent(MainActivity.this, AuthActivity.class));
                            finish();
                        }
                    });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    /*private void loadNavigationDrawerHeader(View header) {
        TextView userNameTextViewNav = header.findViewById(R.id.current_user_name);
        TextView userEmailTextViewNav = header.findViewById(R.id.user_email);
        ImageView profile_imageView = header.findViewById(R.id.profile_imageView);


        if (user != null) {
            userNameTextViewNav.setText(user.getDisplayName());
            userEmailTextViewNav.setText(user.getEmail());
            Glide.with(this).load(user.getPhotoUrl()).into(profile_imageView);
            User userApp = new User();
            String photoUrl = null;
            if (user.getPhotoUrl() != null) {
                userApp.setPhotoUrl(user.getPhotoUrl().toString());
            }

            userApp.setEmail(user.getEmail());
            userApp.setUser(user.getDisplayName());
            userApp.setUid(FirebaseAuth.getInstance().getCurrentUser().getUid());
            FirebaseUtils.getUserRef(user.getEmail().replace(".", ",")).setValue(userApp);

        }
    }*/

}
