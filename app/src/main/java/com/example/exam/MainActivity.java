package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;
    RadioButton radioButton;
    CheckBox hobby1,hobby2,hobby3;
    EditText name,num,email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        group=findViewById(R.id.group);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        num=findViewById(R.id.number);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setError(null);
                email.setError(null);
                num.setError(null);
                if(name.getText().toString().isEmpty())
                {
                    name.setError("Name is Required");
                }
                if(email.getText().toString().isEmpty()) {
                    email.setError("Email is Required");
                }
                if(num.getText().toString().isEmpty())
                {
                    num.setError("Number is Required");
                }
                if(num.getText().toString().length()!=10)
                {
                    num.setError("Number should be 10 digits");
                }
                radioButton=findViewById(group.getCheckedRadioButtonId());
                if(radioButton==null)
                {
                    Toast t1=new Toast(getApplicationContext());
                    t1.setText("Gender is Required");
                    t1.show();
                }
                else{
                   String gender= radioButton.getText().toString();
                   String name1=name.getText().toString();
                   String email1=email.getText().toString();
                   String num1=num.getText().toString();
                    Intent i=new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name",name1);
                    i.putExtra("phone",num1);
                    i.putExtra("gender",gender);
                    i.putExtra("email",email1);
                    startActivity(i);
                }
            }
        });
    }
}