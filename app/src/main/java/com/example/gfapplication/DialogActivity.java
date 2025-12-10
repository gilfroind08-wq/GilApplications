package com.example.gfapplication;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sp;
    Dialog d;
    EditText etUserName, etPass;
    Button btnCustomLogin, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ייזום SharedPreferences
        sp = getSharedPreferences("details1", MODE_PRIVATE);

        // ייזום כפתור מתוך ה-Activity הראשי והאזנה ללחיצה עליו
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    // יצירת דיאלוג Login מותאם אישית
    public void createLoginDialog() {
        d = new Dialog(this);
        d.setContentView(R.layout.custom_layout);
        d.setTitle("Login");
        d.setCancelable(true);

        etUserName = d.findViewById(R.id.etUserName);
        etPass = d.findViewById(R.id.etPassword);
        btnCustomLogin = d.findViewById(R.id.btnDialogLogin);
        btnCustomLogin.setOnClickListener(this);

        d.show();
    }

    @Override
    public void onClick(View v) {
   if (v = btnLogin){
       createLoginDialog();
        } else if (v= btnCustomLogin) {
       Toast.makeText(this, "username and password saved", Toast.LENGTH_SHORT).show();
       d.dismiss();
   }
    }
}
