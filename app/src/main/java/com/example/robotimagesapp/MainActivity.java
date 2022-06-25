package com.example.robotimagesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView description;
    Button back, next;
    ImageView robotImg;

    String[] imageDescription = {"2009 Robot", "2010 Robot", "2011 Robot", "2013 Robot", "2014 Robot", "2017 Robot", "2018 Robot", "2019 Robot"};
    int[] imageIds = {R.drawable.robot2009, R.drawable.robot2010, R.drawable.robot2011, R.drawable.robot2013, R.drawable.robot2014, R.drawable.robot2017, R.drawable.robot2018, R.drawable.robot2019};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = findViewById(R.id.imageDescriptionTxtView);
        description.setText(imageDescription[0]); //default text is "2009 Robot"

        back = findViewById(R.id.backBtn);
        next = findViewById(R.id.nextBtn);

        robotImg = findViewById(R.id.robotImgView);
        robotImg.setImageResource(R.drawable.robot2009); //default image is 2009

        //onclick listeners
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lets traverse through the array for desc and find the current year that is showing
                int index = -1;
                for(int i = 0; i < imageDescription.length; i++) {
                    if(description.getText().equals(imageDescription[i]))
                        index = i;
                }
                if(index > 0) {
                    robotImg.setImageResource(imageIds[index-1]);
                    description.setText(imageDescription[index-1]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "OLDEST YEAR IS 2009!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = -1;
                for(int i = 0; i < imageDescription.length; i++) {
                    if(description.getText().equals(imageDescription[i]))
                        index = i;
                }
                if(index < 7) {
                    robotImg.setImageResource(imageIds[index+1]);
                    description.setText(imageDescription[index+1]);
                }
                else{
                    Toast.makeText(getApplicationContext(), "LATEST YEAR IS 2019", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}