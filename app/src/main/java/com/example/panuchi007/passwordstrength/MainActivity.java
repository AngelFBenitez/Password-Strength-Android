package com.example.panuchi007.passwordstrength;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textViewStatus;
    EditText editTextPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);// intilize the TextView
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);// intilize the Editext



            editTextPassword.addTextChangedListener(new TextWatcher() {   // it will check the text of the editext
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                     //will check the text before
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { // this method will check text when we type
                }

                @Override
                public void afterTextChanged(Editable editable) { // This method will check after text is changed
                    String pass = editTextPassword.getText().toString(); // pass string
                    // Patterns
                    Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
                    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
                    Pattern digitCasePatten = Pattern.compile("[0-9 ]");

                    // If statements to check for the password requirements.
                        if (pass.length() < 8) {
                            textViewStatus.setText("Invalid");
                            return;
                        }
                        if (!specailCharPatten.matcher(pass).find()) {
                            textViewStatus.setText("Invalid");
                        }
                        if (!UpperCasePatten.matcher(pass).find()) {
                            textViewStatus.setText("Invalid");
                        }
                        if (!lowerCasePatten.matcher(pass).find()) {
                            textViewStatus.setText("Invalid");
                        }
                        if (!digitCasePatten.matcher(pass).find()) {
                            textViewStatus.setText("Invalid");
                        }

                    if (specailCharPatten.matcher(pass).find() && UpperCasePatten.matcher(pass).find() && lowerCasePatten.matcher(pass).find() && digitCasePatten.matcher(pass).find() )
                    {
                        textViewStatus.setText("valid");
                    }
                        }
            });
        }
    }
