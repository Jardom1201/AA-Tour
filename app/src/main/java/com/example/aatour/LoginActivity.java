package com.example.aatour;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference tb_user = FirebaseDatabase.getInstance().getReference("users");
    EditText mUsername,mPassword;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signup = findViewById(R.id.signup);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);



      signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);



            }
        });

        Button signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(mUsername.getText().toString(), mPassword.getText().toString());
//                Intent i = new Intent(LoginActivity.this, HomePage.class);
//                startActivity(i);



            }
        });
    }

    private void submit(String email, final String  password){


        tb_user.orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    for(DataSnapshot ds : dataSnapshot.getChildren()){

                        if(ds.child("password").getValue(String.class).equals(password)){

                            sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString("email",ds.child("email").getValue(String.class));

                            editor.commit();



                            Intent intent = new Intent(LoginActivity.this, HomePage.class);

                            startActivity(intent);

                            finish();

                        }else{

                            Toast.makeText(LoginActivity.this,"Wrong email/password !",Toast.LENGTH_SHORT).show();

                        }

                    }

                }else{

                    Toast.makeText(LoginActivity.this,"Wrong email/password !",Toast.LENGTH_SHORT).show();

                }

            }



            @Override

            public void onCancelled(@NonNull DatabaseError databaseError) {



            }

        });

    }
}
