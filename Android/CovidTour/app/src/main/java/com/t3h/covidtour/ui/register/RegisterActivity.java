package com.t3h.covidtour.ui.register;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.basemodule.base.BaseActivity;
import com.t3h.covidtour.R;
import com.t3h.covidtour.databinding.ActivityRegisterBinding;
import com.t3h.covidtour.utils.Validator;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> implements RegisterListener {
    @Override
    protected Class<RegisterViewModel> getViewModelClass() {
        return RegisterViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setListener(this);
        viewModel.getIsSuccess().observe(this, response -> {
            if (response != null) {
                finish();
            }
        });
    }

    @Override
    public void onRegisterClicked() {
        if (Validator.isEmpty(binding.edtName, binding.edtUserName, binding.edtPassword)) {
            return;
        }
        String email = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String name = binding.edtName.getText().toString();
        viewModel.register(email, name, password);
    }
}
