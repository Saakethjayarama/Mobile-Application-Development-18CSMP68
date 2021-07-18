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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnSignup;

    String regulareExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if(validatePassword(password)) {

            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("data", bundle);
            startActivity(intent);

        } else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(regulareExpression);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}