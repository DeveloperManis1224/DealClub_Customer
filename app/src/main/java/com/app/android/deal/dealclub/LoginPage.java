package com.app.android.deal.dealclub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.android.deal.dealclub.Db.Repo;
import com.app.android.deal.dealclub.Db.RepoDatabase;
import com.app.android.deal.dealclub.Network.ApiCommunicator;


public class LoginPage extends AppCompatActivity {

    private EditText eUserName;
    private EditText ePassWord;
    private Button mLoginBtn;
    private ProgressDialog dialog;
    private Button btn_register;
ApiCommunicator apiCommunicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading,Please Wait...");
        eUserName = findViewById(R.id.edt_username);
        ePassWord = findViewById(R.id.edt_password);
        mLoginBtn = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        apiCommunicator = new ApiCommunicator(this);

        RepoDatabase
                .getInstance(LoginPage.this)
                .getRepoDao()
                .insert(new Repo("1","111","Shoes",
                        "55%","11/9/2018", "11/9/2019",
                        "dgfdfghfghfghdfhgdhghdfgdhdfghdfghjgfmhjf dyudyujytduty uty utyutyutyutyu"));
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(isValid())
        {
            String username = eUserName.getText().toString();
            String password = ePassWord.getText().toString();
            PostLogin(username,password);
        }
    }
});
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginPage.this,RegisterPage.class);
               startActivity(intent);
            }
        });


    }

    private boolean isValid()
    {
        boolean val = true;
        if(eUserName.getText().toString().isEmpty())
        {
            val= false;
            eUserName.setError(getString(R.string.valid_fail));
        }
        if(ePassWord.getText().toString().isEmpty())
        {
            val= false;
            ePassWord.setError(getString(R.string.valid_fail));
        }
        return val;
    }

    private void PostLogin(String username,String password) {

    apiCommunicator.Login_Post(username,password);

    }


    public void initProcess() {









    }



}
