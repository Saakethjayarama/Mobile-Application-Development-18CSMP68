package in.ac.jyothyit.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    String userName,password;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        Bundle bundle = getIntent().getBundleExtra("data");
        userName = bundle.getString("username");
        password = bundle.getString("password");


        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String txtUsername = etUsername.getText().toString();
        String txtPassword = etPassword.getText().toString();

        System.out.println(txtPassword);
        System.out.println(txtUsername);
        System.out.println(userName);
        System.out.println(password);




        if(txtPassword.equals(password) && txtUsername.equals(userName)) {
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        }else {

            Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();

            count++;
            if(count >= 3) {
                btnLogin.setEnabled(false);
            }
        }
    }
}