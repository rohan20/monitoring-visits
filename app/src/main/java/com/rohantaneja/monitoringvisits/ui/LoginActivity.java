package com.rohantaneja.monitoringvisits.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;

public class LoginActivity extends BaseActivity {

    EditText email,password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.edit_text_email_login);

        password=findViewById(R.id.edittext_password_login);
        password.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==EditorInfo.IME_ACTION_DONE)
                {
                    Toast.makeText(LoginActivity.this,"done pressed",Toast.LENGTH_LONG).show();
                    login();
                }
                return false;
            }


        });

    }

    public void login(View view)
    {
        login();
    }

    private boolean login()
    {
        String emailString=email.getText().toString(),pass=password.getText().toString();
        String text = "";
        if(emailString.isEmpty() || pass.isEmpty())
        {
            text="Enter both email and password";
        }
        else if(!emailString.matches(emailPattern))
        {
            Log.wtf("nsfjf",String.valueOf(emailString.matches(emailPattern)));
            Toast.makeText(LoginActivity.this,"Enter valid Email Address",Toast.LENGTH_SHORT);
            return true;
        }
        else
            text="login pressed";
        Toast.makeText(LoginActivity.this,text,Toast.LENGTH_SHORT).show();
        return true;
    }
}
