package com.amani.ai;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amani_ai.Amani;
import com.amani_ai.screens.kyc.view.KYCStepsActivity;
import com.amani_ai.screens.nfc.view.NFCScanActivity;
import com.amani.ai.BuildConfig;

public class MainActivity extends AppCompatActivity {

    int versionCode = BuildConfig.VERSION_CODE;
    String versionName = BuildConfig.VERSION_NAME;
    String TAG = "AppVersionTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText=findViewById(R.id.search_editText);
        EditText email = findViewById(R.id.email_editText);
        EditText password = findViewById(R.id.password_editText);
        Toast.makeText(this,"App version: "+ versionName,Toast.LENGTH_SHORT).show();
        Log.d(TAG,"App version: "+ versionName);
        findViewById(R.id.btn).setOnClickListener(
                view -> {
                    Amani.getInstance().goToKycActivity(this, editText.getText().toString(), email.getText().toString(), password.getText().toString());

                });

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}