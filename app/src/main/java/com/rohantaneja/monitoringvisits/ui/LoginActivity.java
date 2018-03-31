package com.rohantaneja.monitoringvisits.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    EditText email,password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    SharedPreferences sharedPreferences;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.edit_text_email_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading");

        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);

        if(sharedPreferences.contains("user"))
        {
            Log.wtf("token:",sharedPreferences.getString("user","temp"));
            Intent intent = new Intent(LoginActivity.this,ViewTaskActivity.class);
            startActivity(intent);
            finish();
        }
        password=findViewById(R.id.edittext_password_login);
        password.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==EditorInfo.IME_ACTION_DONE)
                {
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

    public void goToRegister(View view){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean login()
    {
        String emailString=email.getText().toString(),pass=password.getText().toString();
        String text = "";
        if(emailString.isEmpty() || pass.isEmpty())
        {
            text="Enter both email and password";
            Toast.makeText(LoginActivity.this,text,Toast.LENGTH_SHORT).show();
        }
        else if(!emailString.matches(emailPattern))
        {
            Toast.makeText(LoginActivity.this,"Enter valid Email Address",Toast.LENGTH_SHORT).show();
            //return true;
        }
        else{
            progressDialog.show();
            Call<User> call = RESTAdapter.getInstance().getMinistryDataAPI().login(emailString,pass);
            Log.wtf("URL Called", call.request().url() + "");
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    progressDialog.dismiss();
                    //{"oid":0} is returned in case of unregistered user
                    if(user !=null && user.getEmail() != null){
                        Gson gson = new Gson();

                        String userString = gson.toJson(user);
                        sharedPreferences.edit().putString("user",userString).apply();
                        Log.wtf("token:",sharedPreferences.getString("user","SIH"));
                        Intent intent = new Intent(LoginActivity.this,ViewTaskActivity.class);
                        Log.wtf("email:",user.getEmail());
                        Log.wtf("name",user.getName());
                        Log.wtf("isAdmin",String.valueOf(user.isAdmin()));
                        Bundle bundle = new Bundle();
                        bundle.putString("email",user.getEmail());
                        bundle.putString("name",user.getName());
                        bundle.putBoolean("isAdmin",user.isAdmin());
                        intent.putExtras(bundle);
                        FirebaseInstanceId.getInstance().getToken();
                        startActivity(intent);


                    }
                    else {
                        //TODO
                        showToast("Please register first");
                        Log.wtf("error:","no data received");

                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    progressDialog.dismiss();
                    showToast(t.getMessage());
                }
            });
        }


        return true;
    }
}
