package com.connect;

import android.content.Intent;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.TextUtils;
//import android.text.TextUtils;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    //private TextView txtDetails;
    private EditText inputName, inputPhone;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;
    private Button buttonLogout;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        inputName = findViewById(R.id.name);
        inputPhone = findViewById(R.id.phnum);
        final Button btnSave = findViewById(R.id.btn_save);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
         if (user == null) {
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser FBuser = FirebaseAuth.getInstance().getCurrentUser();
        if (FBuser != null){
            userId = FBuser.getUid();
        }


        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = inputName.getText().toString();
                String phonenumber = inputPhone.getText().toString();

                createUser(name, phonenumber);
                openUsersProfActivity();
                finish(); //killing ProfileActivity.java
            }
        });

        buttonLogout = findViewById(R.id.logout);
        buttonLogout.setOnClickListener(this);
    }

    public void openUsersProfActivity(){

        Intent intent = new Intent(this, users_prof.class);  //opening users_prof.java activity
        startActivity(intent);
    }

    public void createUser(String name, String phonenumber) {
        User user = new User(name, phonenumber);
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        mFirebaseDatabase.child(userId).setValue(user);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}

/*DANGER-AHEAD 30-12-2020*/