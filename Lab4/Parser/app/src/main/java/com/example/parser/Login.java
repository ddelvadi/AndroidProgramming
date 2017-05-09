package com.example.parser;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    int attmpt=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Context context = getApplicationContext();
        final String name="Mary";
        final String passwd="123";
        final EditText usrnm,pass;
        Button btn;
        usrnm=(EditText)findViewById(R.id.loginusrnm);
        pass=(EditText)findViewById(R.id.loginpasswd);
        btn=(Button)findViewById(R.id.btnLogin);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usrnm.getText().toString().equals(name) && pass.getText().toString().equals(passwd))
                {
                    Toast.makeText(context,"Redirecting......", Toast.LENGTH_LONG).show();
                  Intent i=new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    attmpt--;
                    if(attmpt<0)
                    {
                        Toast.makeText(context,"No Attempt is left", Toast.LENGTH_LONG).show();
                    }
                    else
                    Toast.makeText(context,"Wrong Credential. "+attmpt+" attempt left", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
