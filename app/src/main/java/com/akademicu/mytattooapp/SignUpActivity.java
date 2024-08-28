package com.akademicu.mytattooapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText firstName, password, location, email;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName = findViewById(R.id.firstName);
        password = findViewById(R.id.password);
        location = findViewById(R.id.location);
        email = findViewById(R.id.email);
        signUp = findViewById(R.id.sign_up_butten);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fieldsValidator()){
                    Toast.makeText(SignUpActivity.this, "successful",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void backToHome(View view){
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToSingInAct(View view){
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    protected boolean fieldsValidator(){
        if(Validation.textFieldValidator(firstName.getText().toString())){
            firstName.setError("First name can not be empty");
            return false;
        }
        if(Validation.textFieldValidator(password.getText().toString())){
            password.setError("Password can not be empty");
            return false;
        }
        if(Validation.textFieldValidator(location.getText().toString())){
            location.setError("Location can not be empty");
            return false;
        }
        if(Validation.textFieldValidator(email.getText().toString())){
            email.setError("Email can not be empty");
            return false;
        }
        return true;
    }
}