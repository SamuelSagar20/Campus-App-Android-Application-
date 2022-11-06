package com.example.jitcampusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail,mPassword;
    TextView mRegisterBtn,forgotPasswordlink;
    Button mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    ImageView showhideimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
        fAuth = FirebaseAuth.getInstance();
        mRegisterBtn = findViewById(R.id.new_user);
        mLoginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progressBar);
        forgotPasswordlink = findViewById(R.id.forgotPassword);
        showhideimg = findViewById(R.id.show_hide_icon);

        showhideimg.setImageResource(R.drawable.show_pass);
        showhideimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showhideimg.setImageResource(R.drawable.show_pass);
                } else {
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showhideimg.setImageResource(R.drawable.hide_pass);
                }
            }
        });

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MenuActivity.class));
            finish();
        }

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }
                if(password.length() < 6){
                    mPassword.setError("Password must have minimum of 6 characters ");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                        }else {
                            Toast.makeText(LoginActivity.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

      mRegisterBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
              overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

          }
      });

      forgotPasswordlink.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              EditText resetMail = new EditText(view.getContext());
              AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
              passwordResetDialog.setTitle("Reset Password ?");
              passwordResetDialog.setMessage("Enter Your Email To Receive Reset Link (Check Spam Folder)");

              passwordResetDialog.setView(resetMail);

              passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String mail = resetMail.getText().toString();
                      fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                          @Override
                          public void onSuccess(Void aVoid) {
                              Toast.makeText(LoginActivity.this, "Reset Link Sent To Your Email", Toast.LENGTH_SHORT).show();
                          }
                      }).addOnFailureListener(new OnFailureListener() {
                          @Override
                          public void onFailure(@NonNull Exception e) {
                              Toast.makeText(LoginActivity.this, "Error ! Reset Link is Not Sent " + e.getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      });
                  }
              });

              passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                  }
              });

              passwordResetDialog.create().show();

          }
      });
    }
}
