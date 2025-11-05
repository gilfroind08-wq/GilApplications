package com.example.gfapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     SeekBar seekBar;
     Switch switch2;
    private ImageView myImage;
    private Button toggleButton, darkButton, brightButton;
    private boolean isImageVisible = true;
    private float brightness = 1.0f; // ברירת מחדל - בהירות רגילה

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            SeekBar seekBar = findViewById(R.id.seekBar);
            myImage = findViewById(R.id.myImage);
            toggleButton = findViewById(R.id.toggleButton);
            darkButton = findViewById(R.id.darkButton);
            brightButton = findViewById(R.id.brightButton);
            switch2 = findViewById(R.id.switch2);

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



        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
          ;          myImage.setVisibility(View.INVISIBLE);
                } else {
                    myImage.setVisibility(View.VISIBLE);
                }
                isImageVisible = !isImageVisible;
            }

        });{

seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        float alpha = i / 100f; //
        myImage.setAlpha(alpha);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this, "נלחץ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this, "שוחרר", Toast.LENGTH_SHORT).show();
    }
});
                                           }

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
