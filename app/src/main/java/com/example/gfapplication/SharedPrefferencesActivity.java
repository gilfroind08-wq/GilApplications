package com.example.gfapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPrefferencesActivity extends AppCompatActivity {

    SharedPreferences sp;
    Button saveButton;
    EditText firstName, lastName;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_prefferences);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sp = getSharedPreferences("myfile", MODE_PRIVATE);

        tvDisplay = findViewById(R.id.tvDisplay);
        saveButton = findViewById(R.id.saveButton);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);





        String strFname = sp.getString("fname", null);
        String strLname = sp.getString("lname", null);

        if (strFname != null && strLname != null) {
            tvDisplay.setText("welcome! " + strFname + " " + strLname);
        }


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("fname", firstName.getText().toString());
                editor.putString("lname", lastName.getText().toString());
                editor.apply();

                tvDisplay.setText("welcome! "
                        + firstName.getText().toString()
                        + " " + lastName.getText().toString());
            }
        });
    }
}
