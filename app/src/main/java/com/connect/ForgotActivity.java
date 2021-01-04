package com.connect;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

     EditText editForgotEmail;
     Button reset;
     Button contactus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        reset = (Button) findViewById(R.id.buttonreset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgotPassword(); //error here
            }
        });
        contactus=(Button)findViewById(R.id.buttoncontact);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //need to add this section too
            }
        });
    }



    private void ForgotPassword() {

        String email = editForgotEmail.getText().toString().trim();
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            Toast.makeText(ForgotActivity.this,"Email sent",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ForgotActivity.this, "Error!", Toast.LENGTH_LONG).show();
                    }
                });
    }
}