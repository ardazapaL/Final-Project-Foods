package com.example.videofoods;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    EditText editTextEmail, editTextPass;
    Button buttonLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextEmail = view.findViewById(R.id.input_email);
        editTextPass = view.findViewById(R.id.input_password);
        buttonLogin = view.findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });

        return view;
    }

    private void login() {

        if (editTextEmail.getText().toString().equals("admin") &&
            editTextPass.getText().toString().equals("admin")) {

            Intent goLogin = new Intent(getActivity(), MainActivity.class);
            startActivity(goLogin);
        }
    }
}
