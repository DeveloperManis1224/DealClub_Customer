package com.app.android.deal.dealclub;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.app.android.deal.dealclub.Network.ApiCommunicator;

import java.util.Calendar;

public class RegisterPage extends AppCompatActivity {
    private static final String TAG ="" ;

    EditText reg_name,reg_phone,reg_email,reg_password,reg_gender;
    Button button_reg;
    ApiCommunicator apiCommunicator;
    EditText reg_dob;
    int mYear,mMonth,mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        reg_name = findViewById(R.id.reg_name);
        reg_phone = findViewById(R.id.reg_phone);
        reg_email = findViewById(R.id.reg_email);
        reg_password = findViewById(R.id.reg_password);
        button_reg = findViewById(R.id.button_reg);
        reg_gender = findViewById(R.id.reg_gender);
        reg_dob= findViewById(R.id.reg_dob);

                Calendar mcurrentDate=Calendar.getInstance();
                mYear=mcurrentDate.get(Calendar.YEAR);
                 mMonth=mcurrentDate.get(Calendar.MONTH);
                 mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);
        reg_dob.setKeyListener(null);
        reg_gender.setKeyListener(null);
        reg_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To show current date in the datepicker


                DatePickerDialog mDatePicker=new DatePickerDialog(RegisterPage.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        /*      Your code   to get date and time    */
                        reg_dob.setText(mDay+":"+mMonth+":"+mYear);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });


        reg_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             final   String[] singleChoiceItems={"Male","Female"};
                int itemSelected = 0;
                new AlertDialog.Builder(RegisterPage.this)
                        .setTitle("Select your gender")
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedIndex) {
                                reg_gender.setText(singleChoiceItems[selectedIndex]);
                            }
                        })
                        .setPositiveButton("Ok", null)
                        .setNegativeButton("Cancel", null).show();
            }
        });
        apiCommunicator = new ApiCommunicator(this);
        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isValid())
                {
                    String name=reg_name.getText().toString();
                    String phone=reg_phone.getText().toString();
                    String email=reg_email.getText().toString();
                    String password=reg_password.getText().toString();
                    String dob=reg_dob.getText().toString();
                    String gender=reg_gender.getText().toString();
                    PerformRegistration(name,phone,email,dob,gender,password);
                }


            }


        });
    }


    private boolean isValid()
    {
        boolean val = true;

        if(reg_name.getText().toString().isEmpty())
        {
            val= false;
            reg_name.setError(getString(R.string.valid_fail));
        }
        if(reg_email.getText().toString().isEmpty())
        {
            val= false;
            reg_email.setError(getString(R.string.valid_fail));
        }
        if(reg_phone.getText().toString().isEmpty())
        {
            val= false;
            reg_phone.setError(getString(R.string.valid_fail));
        }
        if(reg_gender.getText().toString().isEmpty())
        {
            val= false;
            reg_gender.setError(getString(R.string.valid_fail));
        }
        if(reg_password.getText().toString().isEmpty())
        {
            val= false;
            reg_password.setError(getString(R.string.valid_fail));
        }
        if(reg_dob.getText().toString().isEmpty())
        {
            val= false;
            reg_dob.setError(getString(R.string.valid_fail));
        }


        return val;
    }



    private void PerformRegistration(String name, String phone, String email,String dob,String gender, String password) {


        apiCommunicator.Register_Post(name,phone,email,dob,gender,password);
    }
    public void showDatePicker(View v) {
        DialogFragment newFragment = new MyDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "date picker");
    }


}
