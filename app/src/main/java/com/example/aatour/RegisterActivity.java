package com.example.aatour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText Username,Password,Email,No_telphon;
    DatabaseReference tb_user= FirebaseDatabase.getInstance().getReference("users");
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);


            }



        });
        Username=findViewById(R.id.usernameRegister);
        Password=findViewById(R.id.passwordRegister);
        Email=findViewById(R.id.email);
        No_telphon=findViewById(R.id.notelp);

        signup = findViewById(R.id.signup);

                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String usr = Username.getText().toString();
                        String pss = Password.getText().toString();
                        String email = Email.getText().toString();
                        String notlp = No_telphon.getText().toString();
                        String id = tb_user.push().getKey();
                        Users user = new Users(usr,notlp,pss,email);
                        tb_user.child(id).setValue(user);

                Intent login = new Intent (RegisterActivity.this,LoginActivity.class);

                startActivity(login);
                finish();

            }
        });


    }

}
