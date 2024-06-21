package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        {/*  plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        power = findViewById(R.id.power);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);

        answer = findViewById(R.id.answer);*/}

        binding.plus.setOnClickListener(this);
        binding.minus.setOnClickListener(this);
        binding.mul.setOnClickListener(this);
        binding.div.setOnClickListener(this);
        binding.power.setOnClickListener(this);


    }
    public  int getIntFromEditText(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        try {
            num1 = getIntFromEditText(binding.number1);
            num2 = getIntFromEditText(binding.number2);

            switch (view.getId()) {
                case R.id.plus:
                    binding.answer.setText("Answer = " + (num1 + num2));
                    break;

                case R.id.minus:
                    binding.answer.setText("Answer = " + (num1 - num2));
                    break;

                case R.id.mul:
                    binding.answer.setText("Answer = " + (num1 * num2));
                    break;

                case R.id.div:
                    if (num2 != 0) {
                        binding.answer.setText("Answer = " + ((float) num1 / num2));
                    } else {
                        binding.answer.setText("Cannot divide by zero");
                    }
                    break;

                case R.id.power:
                    binding.answer.setText("Answer = " + (Math.pow(num1, num2)));
                    break;
            }
        } catch (NumberFormatException e) {
            binding.answer.setText("Invalid input");
        }
    }
}