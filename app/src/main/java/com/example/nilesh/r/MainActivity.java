package com.example.nilesh.r;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



     EditText email, name;
    String _email,_name;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email=(EditText)findViewById(R.id.editText);
        name=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    public void register(){
        initialize();

        if(!validate()){
            Toast.makeText(this,"Sign up failure",Toast.LENGTH_SHORT).show();
        }else {
            onsignupsuccess();
        }
    }

    public void onsignupsuccess(){


    }


    public boolean validate(){
        boolean valid=true;
        if(_email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(_email).matches()){
            email.setError("Please enter a valid email");
            valid=false;
        }


        if(_name.isEmpty()|| _name.length()>32){
            name.setError("Please enter a valid name");
            valid=false;
        }
        return valid;
    }
    public void initialize(){
        _email=email.getText().toString().trim();
        _name=name.getText().toString().trim();
    }
}








