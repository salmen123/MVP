package tn.esprit.salmen.mvp.model;

import android.text.TextUtils;

import tn.esprit.salmen.mvp.presenter.ILoginPresenter;
import tn.esprit.salmen.mvp.view.ILoginView;

/**
 * Created by Salmen on 26/03/2018.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    ILoginView mLoginView;

    public LoginPresenterImpl(ILoginView mLoginView) {
        this.mLoginView = mLoginView;
    }

    @Override
    public void performLogin(String userName, String password) {

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            mLoginView.loginValidations();
        }
        else
        if (userName.equals("salmen") && password.equals("password")) {
            mLoginView.loginSucces();
        }
        else {
            mLoginView.loginError();
        }
    }

}
