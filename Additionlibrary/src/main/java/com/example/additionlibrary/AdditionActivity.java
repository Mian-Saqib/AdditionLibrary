package com.example.additionlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdditionActivity extends AppCompatActivity {

    private EditText first_num_et,second_num_et;

    private Button add_btn,finish_btn;

    Double Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        BindViews();
        AdditionButtonFun();
        FinishBtnFun();

    }

    private void BindViews()
    {
        first_num_et = findViewById(R.id.first_num_et);
        second_num_et = findViewById(R.id.second_num_et);
        add_btn = findViewById(R.id.add_btn);
        finish_btn = findViewById(R.id.finish_btn);
    }

    private void AdditionButtonFun()
    {
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (first_num_et.getText().toString().isEmpty() || first_num_et.getText().toString().length()==0)
                {
                    first_num_et.setError("Please Enter Some Value");
                }
                else if (second_num_et.getText().toString().isEmpty() || second_num_et.getText().toString().length()==0)
                {
                    second_num_et.setError("Please Enter Some Value");
                }
                else if (first_num_et.getText().toString().isEmpty() && second_num_et.getText().toString().isEmpty())
                {
                    first_num_et.setError("Please Enter Some Value");
                    second_num_et.setError("Please Enter Some Value");
                }
                else
                {
                    Double first_num = Double.valueOf(first_num_et.getText().toString());
                    Double second_num = Double.valueOf(second_num_et.getText().toString());

                    Result = first_num + second_num;
                    Toast.makeText(AdditionActivity.this, "Values Added", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void FinishBtnFun()
    {
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Result!=null)
                {
                    AdditionLibrary.resultMessage(AdditionActivity.this,Result);
                    finish();
                }
            }
        });

    }

}