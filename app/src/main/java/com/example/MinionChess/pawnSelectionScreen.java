//Name: Harkaran Gill
//Date: 17 June 2024
//Purpose: A Class of the Minion Chess final project used to deal with the pawnSelectionScreen
package com.example.MinionChess;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pawnSelectionScreen extends AppCompatActivity {
private int x;//to store number for row
private int y;//to store number for column

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pawn_selection_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pawnScreen), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Get the x and y values passed from MainActivity
        Intent intent = getIntent();
        x = intent.getIntExtra("x", -1);
        y = intent.getIntExtra("y", -1);

        //find the view set up a onClickListener and use lambda expression to override default onClick method and execute the selectPiece() method
        findViewById(R.id.imageViewQueen).setOnClickListener(v ->  selectPiece('q'));
        findViewById(R.id.imageViewRook).setOnClickListener(v -> selectPiece('r'));
        findViewById(R.id.imageViewKnight).setOnClickListener(v -> selectPiece('n'));
        findViewById(R.id.imageViewBishop).setOnClickListener(v -> selectPiece('b'));
    }

    //Select piece method
    private void selectPiece(char piece) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedPiece", piece);
        resultIntent.putExtra("x", x);
        resultIntent.putExtra("y", y);
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}