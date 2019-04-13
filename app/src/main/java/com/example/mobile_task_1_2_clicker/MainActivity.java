package com.example.mobile_task_1_2_clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn;
    Button btn2;
    Button btn3;
    ImageView btn4;
    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainText);
        mainBtn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (ImageView) findViewById(R.id.image_view);


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                score ++;
                if ((score<10 || score > 20) && (score % 10  == 2
                        || score % 10   == 3 || score % 10 == 4) ){
                    s = "Кнопка нажата " + score + " раза";
                }
                else if ((score >= 10 && score  <= 20) || (score > 20 && score % 10  != 2
                        || score % 10   != 3 || score % 10 != 4 )){
                    s = "Кнопка нажата " + score + " раз";
                }

                mainText.setText(s.toCharArray(),0, s.length());
            }
        };
        View.OnClickListener DeleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                if (score == 0){
                    s = "Кнопка нажата " + score + "раз";
                    mainText.setText(s.toCharArray(),0, s.length());
                }
                else {
                    score --;
                    if ((score<10 || score > 20) && (score % 10  == 2
                            || score % 10   == 3 || score % 10 == 4) ){
                        s = "Кнопка нажата " + score + " раза";
                    }
                    else if ((score >= 10 && score  <= 20) || (score > 20 && score % 10  != 2
                            || score % 10   != 3 || score % 10 != 4 )){
                        s = "Кнопка нажата " + score + " раз";
                    }
                    mainText.setText(s.toCharArray(),0, s.length());
                }


            }
        };
        View.OnClickListener RestartListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;
                String s = "Кликов: " + score;
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };
        View.OnClickListener ImageListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                score ++;
                if ((score<10 || score > 20) && (score % 10  == 2
                        || score % 10   == 3 || score % 10 == 4) ){
                    s = "Кнопка нажата " + score + " раза";
                }
                else if ((score >= 10 && score  <= 20) || (score > 20 && score % 10  != 2
                        || score % 10   != 3 || score % 10 != 4 )){
                    s = "Кнопка нажата " + score + " раз";
                }

                mainText.setText(s.toCharArray(),0, s.length());
            }
        };

        mainBtn.setOnClickListener(clickListener);
        btn2.setOnClickListener(DeleteListener);
        btn3.setOnClickListener(RestartListener);
        btn4.setOnClickListener(ImageListener);
    }
}


