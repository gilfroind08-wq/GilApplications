package com.example.gfapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     Button openSecondButton = findViewById(R.id.openSecondButton);
    private ImageView myImage;
    private Button toggleButton, darkButton, brightButton;
    private boolean isImageVisible = true;
    private float brightness = 1.0f; // ברירת מחדל - בהירות רגילה

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            myImage = findViewById(R.id.myImage);
            toggleButton = findViewById(R.id.toggleButton);
            darkButton = findViewById(R.id.darkButton);
            brightButton = findViewById(R.id.brightButton);


        // כפתור הצגה / הסתרה
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImageVisible) {
                    myImage.setVisibility(View.INVISIBLE);
                } else {
                    myImage.setVisibility(View.VISIBLE);
                }
                isImageVisible = !isImageVisible;
            }
        });

        // כפתור פחות בהירות
        darkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreaseBrightness();
            }
        });

        // כפתור יותר בהירות
        brightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseBrightness();
            }
        });
    }


    private void increaseBrightness() {
        brightness = Math.min(1f, brightness + 0.2f);
        myImage.setAlpha(brightness);
    }


    private void decreaseBrightness() {
        brightness = Math.max(0f, brightness - 0.2f);
        myImage.setAlpha(brightness);
    }


}
