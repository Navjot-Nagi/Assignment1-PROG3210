package ca.on.conestogac.navjot.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.List;

import data.AppDatabase;
import data.User;

public class LogInActivity extends AppCompatActivity implements OnClickListener {
    //define instance variables for the widgets
    private EditText userName;
    private EditText password;
    private Button LogIn;
    private Button Register;
    private Toast successLogin;
    private Toast errMsgUsrPwd;
    private Toast errMsgPassword;
    private Toast errFindUser;
    private User user;
    private AppDatabase database;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogIn = (Button)
                findViewById(R.id.LogInButton);
        userName = (EditText)
                findViewById(R.id.userNameText);
        password = (EditText)
                findViewById(R.id.passwordText);
        Register = (Button)
                findViewById(R.id.registerButton);
        database = AppDatabase.getDatabase(this.getApplication());
        successLogin = Toast.makeText(this, "you are successfully Logged In", Toast.LENGTH_SHORT);
        errFindUser = Toast.makeText(this, "User does not exists", Toast.LENGTH_SHORT);
        errMsgPassword = Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT);
        errMsgUsrPwd = Toast.makeText(this, "Check your User Name and Password", Toast.LENGTH_SHORT);

    }

    public void logInData()
    {
        String userNameString = userName.getText().toString();
        String passwordString = password.getText().toString();
        List<User> userLogin = database.userDao().getUser(userNameString);
        if(userLogin.size() == 0)
        {
            errFindUser.show();
        }
        else if(passwordString.equals(userLogin.get(0).password)){
            Intent mainPage = new Intent(this, MainActivity.class);
            startActivity(mainPage);
            successLogin.show();
        }
        else if(passwordString.equals("login")==false ){
            errMsgPassword.show();
        }
        else {
            errMsgUsrPwd.show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.LogInButton:
                logInData();
                break;
            case R.id.registerButton:
                Intent registerPage = new Intent(this, RegistrationActivity.class);
                startActivity(registerPage);
                break;
        }

    }
}
