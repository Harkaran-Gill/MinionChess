//Name: Harkaran Gill
//Date: 17 June 2024
//Purpose: A Class of the Minion Chess final project used to deal with the OpeningScreen
package com.example.MinionChess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OpeningScreen extends AppCompatActivity {

    //onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_opening_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.openingScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    //Method that switches to the Opening screen
    public void toMain(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}