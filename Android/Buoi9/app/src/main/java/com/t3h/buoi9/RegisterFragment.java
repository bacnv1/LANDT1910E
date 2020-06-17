package com.t3h.buoi9;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "RegisterFragment";
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUserName = getActivity().findViewById(R.id.edt_reg_user_name);
        edtPassword = getActivity().findViewById(R.id.edt_reg_password);
        btnRegister = getActivity().findViewById(R.id.btn_reg_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        final String userName = edtUserName.getText().toString();
        final String password = edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "User name or password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getActivity() instanceof MainActivity) {
            MainActivity main = (MainActivity) getActivity();
            final LoginFragment fmLogin = main.getFmLogin();
//            main.showFragment(fmLogin, new Runnable() {
//                @Override
//                public void run() {
//                    fmLogin.setInfo(userName, password);
//                }
//            });
            main.showFragment(fmLogin);
            fmLogin.setInfo(userName, password);
        }
    }
}
