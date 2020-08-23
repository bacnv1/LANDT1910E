package com.t3h.covidtour.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.t3h.basemodule.base.BaseActivity;
import com.t3h.covidtour.MainActivity;
import com.t3h.covidtour.R;
import com.t3h.covidtour.databinding.ActivityLoginBinding;
import com.t3h.covidtour.models.User;
import com.t3h.covidtour.ui.register.RegisterActivity;
import com.t3h.covidtour.utils.Validator;

public class LoginActivity extends
        BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginListener {
    @Override
    protected Class<LoginViewModel> getViewModelClass() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setListener(this);
        viewModel.getUser().observe(this, user -> {
            if (user != null) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(User.class.getName(), user);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onLoginClicked() {
        if (Validator.isEmpty(binding.edtPassword, binding.edtUserName)) {
            return;
        }
        viewModel.login(
                binding.edtUserName.getText().toString(),
                binding.edtPassword.getText().toString()
        );
    }

    @Override
    public void onRegisterClicked() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
