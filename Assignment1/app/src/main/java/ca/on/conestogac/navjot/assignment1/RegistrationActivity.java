package ca.on.conestogac.navjot.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import data.AppDatabase;
import data.User;


public class RegistrationActivity extends AppCompatActivity implements OnClickListener {

    private Button register;
    private Toast successRegister;
    private Toast errMsg;
    private Toast errRegistration;
    private Toast validFields;
    private EditText firstName;
    private EditText lastName;
    private EditText userName;
    private EditText password;
    private EditText confirmPassword;
    private User user;
    private AppDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        successRegister = Toast.makeText(this, "you are successfully Registered", Toast.LENGTH_SHORT);
        errMsg = Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT);
        errRegistration = Toast.makeText(this, "User with this user name already exists", Toast.LENGTH_SHORT);
        validFields = Toast.makeText(this, "all fields are required", Toast.LENGTH_SHORT);
        firstName = (EditText)
                findViewById(R.id.FirstNameText);
        lastName = (EditText)
                findViewById(R.id.LastNameText);
        userName = (EditText)
                findViewById(R.id.userNameText);
        password = (EditText)
                findViewById(R.id.rstPasswordText);
        confirmPassword = (EditText)
                findViewById(R.id.rstConfirmPasswordText);
        database = AppDatabase.getDatabase(this.getApplication());
    }

    public void validRegistration(){
        String firstNameString = firstName.getText().toString();
        String lastNameString = lastName.getText().toString();
        String userNameString = userName.getText().toString();
        String passwordString = password.getText().toString();
        String confirmPasswordString = confirmPassword.getText().toString();
        List<User> userRegisteration = database.userDao().getUser(userNameString);
        if(firstNameString.equals("") || lastNameString.equals("") || userNameString.equals("")|| passwordString.equals("") || confirmPasswordString.equals("")){
            validFields.show();
        }
        else if(userRegisteration.size()>0){
            errRegistration.show();

        }
        else if(confirmPasswordString.equals(passwordString) == false){
            errMsg.show();
        }
        else {
            User user = new User(userNameString,passwordString,firstNameString,lastNameString);
            database.userDao().addUser(user);
            successRegister.show();
            Intent logIn = new Intent(this, LogInActivity.class);
            startActivity(logIn);
        }
    }

    @Override
    public void onClick(View view) {

        validRegistration();
    }
}
