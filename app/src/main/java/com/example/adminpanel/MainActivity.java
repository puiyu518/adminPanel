package com.example.adminpanel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    openMainActivity();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void openMainActivity(){
        Intent intent = new Intent(this,AdminActivity.class);
        startActivity(intent);
    }
}
