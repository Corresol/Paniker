package com.yupi.home.panikerapp.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ArrayList<String> languages;
    private ListView listView;
    private TextView selectedLanguage;
    private EditText getEmail, getPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setupUI();
    }

    public void pickupLanguage(View view){
        AlertDialog dialog = setupDialog().create();
        dialog.show();
    }

    private void setupUI(){
        selectedLanguage = (TextView)findViewById(R.id.chooseLanguage);
        getEmail = (EditText)findViewById(R.id.input_email);
        getPassword = (EditText)findViewById(R.id.input_password);

    }
    public void signIn(View view){
        if(getEmail.getText().toString().equals("")
                && getPassword.getText().toString().equals("")){
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Loading");
            progressDialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }
        else {
            errorDialog().show();
        }
    }
    public void signUp(View view){
        startActivity(new Intent(this, SignUpActivity.class));
    }
    private AlertDialog.Builder setupDialog() {
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("German");
        languages.add("French");
        languages.add("Italian");
        languages.add("Spanish");
        languages.add("Chinese");
        languages.add("Portuguese");
        languages.add("Polish");
        languages.add("Romanian");
        View view = getLayoutInflater().inflate(R.layout.dialogs_layout, null);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setView(view);
        listView = (ListView)view.findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String language = languages.get(position);
                selectedLanguage.setText(language);
                AlertDialog alertDialog1 = setupDialog().create();
                alertDialog1.dismiss();
            }
        });
        return alertDialog;
    }
    private AlertDialog.Builder errorDialog(){
        View view = getLayoutInflater().inflate(R.layout.dialog_sign_in_alert, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton(getResources().getString(R.string.report_problem), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setView(view);
        return builder;
    }
}
