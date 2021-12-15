package com.example.additionlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdditionActivity extends AppCompatActivity {

    private EditText first_num_et,second_num_et;

    private Button add_btn,finish_btn;

    Double Result;

    String oprator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        BindViews();
        SpinnerFunctionalityFun();
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

                if (oprator == null)
                {
                    Toast.makeText(AdditionActivity.this, "Please Select Operator", Toast.LENGTH_SHORT).show();
                }
                else
                {
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
                        try {

                            Double first_num = Double.valueOf(first_num_et.getText().toString());
                            Double second_num = Double.valueOf(second_num_et.getText().toString());

                            switch (oprator)
                            {
                                case "+":

                                    Result = first_num + second_num;
                                    break;

                                case "-":

                                    Result = first_num - second_num;
                                    break;

                                case "*":

                                    Result = first_num * second_num;
                                    break;

                                case "/":

                                    Result = first_num / second_num;
                                    break;

                            }

                            Toast.makeText(AdditionActivity.this, "Values Added", Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e)
                        {

                        }


                    }
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


    private void SpinnerFunctionalityFun()
    {
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                oprator = adapterView.getItemAtPosition(i).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}