package com.example.gfapplication;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    LinearLayout linearLayout, llscroll;
    HorizontalScrollView horizontalScrollView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        linearLayout = findViewById(R.id.main);

        ViewCompat.setOnApplyWindowInsetsListener(linearLayout, (v, insets) -> {
            Insets i2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(i2.left, i2.top, i2.right, i2.bottom);
            return insets;
        });

        horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        llscroll = new LinearLayout(this);
        llscroll.setOrientation(LinearLayout.HORIZONTAL);
        llscroll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i <= 100; i++) {
            imageView = new ImageView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(100, 100);
            lp.setMargins(5, 5, 5, 5);
            imageView.setLayoutParams(lp);
            int imageKey = getResources().getIdentifier("img" + i % 4, "drawable", getPackageName());
            imageView.setImageResource(imageKey);
            llscroll.addView(imageView);
        }

        horizontalScrollView.addView(llscroll);
        linearLayout.addView(horizontalScrollView);
    }
}
