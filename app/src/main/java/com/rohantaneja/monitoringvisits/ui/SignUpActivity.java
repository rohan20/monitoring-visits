package com.rohantaneja.monitoringvisits.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;

public class SignUpActivity extends BaseActivity {

    EditText username,password,confirmedPassword,email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = findViewById(R.id.edit_text_username);
        email=findViewById(R.id.edit_text_email);
        password = findViewById(R.id.edittext_password);
        confirmedPassword = findViewById(R.id.edittext_confirm_password);
    }

    public void onSubmit(View view)
    {
        String pass, confPass,emailString,uname;
        boolean emailCheck, passCheck;
        uname = username.getText().toString();
        pass = password.getText().toString();
        confPass = confirmedPassword.getText().toString();
        emailString = email.getText().toString();
        if(!emailString.matches(emailPattern))
            emailCheck=false;
        else
            emailCheck=true;

        if(pass.equals(confPass))
            passCheck=true;
        else
            passCheck=false;

        if(!passCheck || !emailCheck ||pass.length()==0 ||uname.length()==0)
        {
            String text="";
            if(uname.length()==0)
                text="please enter username";
            else if(!emailCheck )
                text="Invalid Email";
            else if(!passCheck)
                text="The two passwords don't match";
            else if(pass.length()==0)
                text="Please enter password";
            Toast.makeText(SignUpActivity.this,text,Toast.LENGTH_LONG).show();
        }
        else{
            //Intent intent(SignUpActivity.this,);
            //startActivity(intent);

            Toast.makeText(SignUpActivity.this,"Success!",Toast.LENGTH_LONG).show();
        }

    }
}
