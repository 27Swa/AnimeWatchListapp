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
import com.example.animewatchlist.Modules.Anime;
import com.example.animewatchlist.Modules.AnimeWithUser;
import com.example.animewatchlist.Modules.User;
import com.example.animewatchlist.Modules.UserAnimeRelation;
import com.example.animewatchlist.Modules.UserWithAnime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<User> users = new ArrayList<>();

        AppDatabase db = AppDatabase.getDb(this);
        UserDao userDao = db.userDao();
        users.addAll(userDao.getAll());

        //variables
        Button signInbtn = findViewById(R.id.sign_in_btn);
        Button register = findViewById(R.id.Register_btn);
        EditText email = findViewById(R.id.Email_field);
        EditText password = findViewById(R.id.Password_field);

        //Login functionality
        signInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = email.getText().toString();
                String inputPass = password.getText().toString();
                boolean LoggedIn = true;
                if(users.isEmpty()){
                    Toast.makeText(getApplicationContext() , "Sign up first!!" , Toast.LENGTH_SHORT).show();
                }
                for (User u:users)
                {
                    LoggedIn = true;
                    if(inputEmail.equals(u.email) && inputPass.equals(u.password)){
                        Intent loggedIn = new Intent(getApplicationContext() , AnimeWatchListRecyclerview.class);
                        loggedIn.putExtra("LoggedInUser" , u.email);
                        Toast.makeText(getApplicationContext() , "Login Successful!!" , Toast.LENGTH_SHORT).show();
                        startActivity(loggedIn);
                        finish();
                        break;
                    }
                    else{
                        LoggedIn = false;
                        //Toast.makeText(getApplicationContext() , "Wrong data!!" , Toast.LENGTH_SHORT).show();
                    }
                }
                if(!(LoggedIn))
                    Toast.makeText(getApplicationContext() , "Wrong data!!" , Toast.LENGTH_SHORT).show();

            }
        });

        //sign up functionality
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpintent = new Intent(getApplicationContext() , SignUpActivity.class);
                startActivity(signUpintent);
                finish();
            }

        });


    }
}