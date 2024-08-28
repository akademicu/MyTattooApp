package com.akademicu.mytattooapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {


    EditText email, password;
    Button signInBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signInBt = findViewById(R.id.sing_in_button);
        signInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkFields()){
                    Toast.makeText(SignInActivity.this,"successful",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void backToHome(View view){
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToSingUpAct(View view){
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    protected boolean checkFields(){
        if(Validation.textFieldValidator(email.getText().toString())){
            email.setError("Email can not be empty");
            return false;
        }
        if (Validation.textFieldValidator(password.getText().toString())){
            password.setError("Password can not be empty");
            return false;
        }

        return true;
    }

}