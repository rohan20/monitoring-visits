package com.rohantaneja.monitoringvisits.ui;

import android.content.Intent;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends BaseActivity {

    EditText name,password,confirmedPassword,email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    SharedPreferences sharedPreferences;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setCancelable(true);
        dialog.setMessage("Loading...");
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.edit_text_name);
        email=findViewById(R.id.edit_text_email);
        password = findViewById(R.id.edittext_password);
        confirmedPassword = findViewById(R.id.edittext_confirm_password);
        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
    }

    public void goToLogin(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }


    public void onSubmit(View view)
    {
        String pass, confPass,emailString,nameString;
        boolean emailCheck, passCheck;
        nameString = name.getText().toString();
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

        if(!passCheck || !emailCheck ||pass.length()==0 ||nameString.length()==0)
        {
            String text="";
            if(nameString.length()==0)
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

            dialog.show();
            Call<User> call = RESTAdapter.getInstance().getMinistryDataAPI().signUp(nameString,emailString,pass);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    dialog.dismiss();
                    if(user != null && user.getEmail() != null){
                        Gson gson = new Gson();
                        String userString = gson.toJson(user);
                        sharedPreferences.edit().putString("user",userString).apply();
                        showToast("Success");
                        Log.w("token signup",sharedPreferences.getString("user","null"));
                        Intent intent = new Intent(SignUpActivity.this,ViewTaskActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("email",user.getEmail());
                        bundle.putString("name",user.getName());
                        bundle.putBoolean("isAdmin",user.isAdmin());
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                    else {
                       //TODO
                        showToast("User null");
                        Log.wtf("error:","no data received");
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    dialog.dismiss();
                    showToast(t.getMessage());
                }
            });

        }

    }
}
