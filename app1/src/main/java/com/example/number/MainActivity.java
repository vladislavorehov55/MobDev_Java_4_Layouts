package com.example.number;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int max_value = 100;
    int min_value = 1;
    int value_gen;
    Dialog dialog;
    TextView text;
    Button ExitButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Error");
        dialog.setContentView(R.layout.dialog_view);
        text = dialog.findViewById(R.id.dialogTextView);
        ExitButton = findViewById(R.id.button2);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        };
        ExitButton.setOnClickListener(clickListener);
    }

    public void onClick(View view) {
        if(!etInput.getText().toString().equals("") && bControl.getText().toString().equals(getResources().getString(R.string.input_value))){
            if(Integer.parseInt(etInput.getText().toString()) >= 1 && Integer.parseInt(etInput.getText().toString()) <= 100){
                if (Integer.parseInt(etInput.getText().toString()) > value_gen){
                    tvInfo.setText(getResources().getString(R.string.ahead));
                }
                else if(Integer.parseInt(etInput.getText().toString()) < value_gen){
                    tvInfo.setText(getResources().getString(R.string.behind));
                }
                else if (Integer.parseInt(etInput.getText().toString()) == value_gen){
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
                }
            }
            else if (Integer.parseInt(etInput.getText().toString())<1 || Integer.parseInt(etInput.getText().toString())>100){
                text.setText(getResources().getString(R.string.error2));
                dialog.show();
            }
        }
        else if(etInput.getText().toString().equals("")&& bControl.getText().toString().equals(getResources().getString(R.string.input_value))){
            text.setText(getResources().getString(R.string.error_fill));
            dialog.show();
        }
        else if (!etInput.getText().toString().equals("") && bControl.getText().toString().equals(getResources().getString(R.string.play_more))){
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
        }
    }
}

