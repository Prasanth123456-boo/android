package com.example.inshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import  android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    AppCompatButton b1,b2;
    String getUserName,getPassword,PrefValue;
    SharedPreferences mypreferances;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypreferances=getSharedPreferences("login",MODE_PRIVATE);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.pswd);
        b1=findViewById(R.id.signin);
        b2=findViewById(R.id.signout);
        PrefValue=mypreferances.getString("email",null);
        if(PrefValue!=null){

            Intent i=new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(i);

        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserName=e1.getText().toString();
                getPassword=e2.getText().toString();
                if(getUserName.equals("abc12@gmail.com")&&getPassword.equals("12345")){
                    SharedPreferences.Editor myedit=mypreferances.edit();
                    myedit.putString("email",getUserName);
                    myedit.commit();

                }
                else{
                    Toast.makeText(getApplicationContext(),"invalid credential",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myedit=mypreferances.edit();
                myedit.clear();
                myedit.commit();
            }
        });
    }
}