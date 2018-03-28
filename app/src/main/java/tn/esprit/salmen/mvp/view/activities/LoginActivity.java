package tn.esprit.salmen.mvp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.salmen.mvp.R;
import tn.esprit.salmen.mvp.model.LoginPresenterImpl;
import tn.esprit.salmen.mvp.presenter.ILoginPresenter;
import tn.esprit.salmen.mvp.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    EditText etUserName, etPassword;
    Button btnLogin;

    ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        mLoginPresenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                mLoginPresenter.performLogin(userName, password);
            }
        });
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "Please Enter userName and Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSucces() {
        Toast.makeText(getApplicationContext(), "Login Succes", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Login Failure", Toast.LENGTH_LONG).show();
    }
}
