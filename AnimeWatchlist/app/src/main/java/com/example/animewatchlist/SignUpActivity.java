package com.example.animewatchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.animewatchlist.Database.AppDatabase;
import com.example.animewatchlist.Database.UserDao;
import com.example.animewatchlist.Modules.User;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AppDatabase db = AppDatabase.getDb(this);
        UserDao userDao = db.userDao();
        //userDao.DeleteAll();
        List<User> users = new ArrayList<>();
        users.addAll(userDao.getAll());

        EditText fname = findViewById(R.id.fname);
        EditText lname = findViewById(R.id.lname);
        EditText signupEmail = findViewById(R.id.signup_Email);
        EditText confirmEmail = findViewById((R.id.confirm_Email));
        EditText password = findViewById(R.id.signup_Password);
        EditText confirmPassword = findViewById(R.id.confirm_Password);
        Button signUp = findViewById(R.id.signUp_btn);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fnameStr = fname.getText().toString();
                String lnameStr = lname.getText().toString();
                String signstr = signupEmail.getText().toString();
                String signconf = confirmEmail.getText().toString();
                String passStr = password.getText().toString();
                String passConf = confirmPassword.getText().toString();
                boolean found = false;
                boolean dataAuth = true;
                if(fnameStr=="" || lnameStr=="" || signstr=="" || signconf=="" || passStr=="" || passConf==""){
                    dataAuth = false;
                    Toast.makeText(getApplicationContext() , "Please Fill Missing Fields!!" , Toast.LENGTH_SHORT).show();
                }
//                else if(passStr.length()<8 || passConf.length()<8){
//                    Toast.makeText(getApplicationContext() , "Choose password atleast 8 characters long!!" , Toast.LENGTH_SHORT).show();
//                    dataAuth = false;
//                }
                else if(!(passStr.equals(passConf))){
                    Toast.makeText(getApplicationContext() , "password dont match!!" , Toast.LENGTH_SHORT).show();
                    dataAuth = false;
                }
                else if(!(signstr.equals(signconf))){
                    Toast.makeText(getApplicationContext() , "Email dont match!!" , Toast.LENGTH_SHORT).show();
                    dataAuth = false;
                }
                else{
                    for (User u:users)
                    {
                        if(u.email.equals(signstr)){
                            Toast.makeText(getApplicationContext() , "Email Already Exist, Return to sign in" , Toast.LENGTH_SHORT).show();
                            found = true;
                            dataAuth = false;
                            break;
                        }
                    }
                }
                if(found == false && dataAuth == true){
                    User nUser = new User();
                    nUser.first_name = fnameStr;
                    nUser.last_name = lnameStr;
                    nUser.email = signstr;
                    nUser.password = passStr;
                    userDao.insertUser(nUser);
                    Intent login = new Intent(getApplicationContext() , MainActivity.class);
                    Toast.makeText(getApplicationContext() , "Registration Successful" , Toast.LENGTH_SHORT).show();
                    startActivity(login);
                    finish();
                }
            }
        });
    }
}