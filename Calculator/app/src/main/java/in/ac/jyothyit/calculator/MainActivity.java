package in.ac.jyothyit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive;
    Button btnSix, btnSeven, btnEight, btnNine;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDot, btnEqual, btnClear;

    EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etResult = findViewById(R.id.etResult);
        etResult.setText("");

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);


        Button[] buttons = new Button[]{
                btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnAdd, btnSub, btnMul, btnDiv, btnDot, btnClear
        };

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = etResult.getText().toString();

                if (expression.contains("/")) {
                    String[] splitExpression = expression.split("/");
                    if (splitExpression.length == 2) {
                        calculate(splitExpression, "/");
                    }
                }

                if (expression.contains("*")) {
                    String[] splitExpression = expression.split(Pattern.quote("*"));
                    if (splitExpression.length == 2) {
                        calculate(splitExpression, "*");
                    }
                }

                if (expression.contains("-")) {
                    String[] splitExpression = expression.split(Pattern.quote("-"));
                    if (splitExpression.length == 2) {
                        calculate(splitExpression, "-");
                    }
                }

                if (expression.contains("+")) {
                    String[] splitExpression = expression.split(Pattern.quote("+"));
                    if (splitExpression.length == 2) {
                        calculate(splitExpression, "+");
                    }
                }

            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnZero)) etResult.append("0");
        if (v.equals(btnOne)) etResult.append("1");
        if (v.equals(btnTwo)) etResult.append("2");
        if (v.equals(btnThree)) etResult.append("3");
        if (v.equals(btnFour)) etResult.append("4");
        if (v.equals(btnFive)) etResult.append("5");
        if (v.equals(btnSix)) etResult.append("6");
        if (v.equals(btnSeven)) etResult.append("7");
        if (v.equals(btnEight)) etResult.append("8");
        if (v.equals(btnNine)) etResult.append("9");

        if (v.equals(btnAdd)) etResult.append("+");
        if (v.equals(btnSub)) etResult.append("-");
        if (v.equals(btnMul)) etResult.append("*");
        if (v.equals(btnDiv)) etResult.append("/");
        if (v.equals(btnDot)) etResult.append(".");
        if (v.equals(btnClear)) etResult.setText("");
    }

    private void calculate(String[] expression, String operator) {
        Double oprnd1 = Double.parseDouble(expression[0]);
        Double oprnd2 = Double.parseDouble(expression[1]);

        switch (operator) {
            case "+":
                etResult.setText(oprnd1+oprnd2 + "");
                break;
            case "-":
                etResult.setText(oprnd1-oprnd2 + "");
                break;
            case "*":
                etResult.setText(oprnd1 * oprnd2 + "");
                break;
            case "/":
                etResult.setText((oprnd1 / oprnd2 + ""));
                break;
            default:
                etResult.setText(0.0 + "");
        }
    }
}