//Name: Harkaran Gill
//Date: 17 June 2024
//Purpose: Main class of the Minion Chess final project
package com.example.MinionChess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;//Reques code for Intent
    int row=8;//number of rows in the grid
    int col=8;//number of columns in the grid
    boolean turnWhite;//variable to keep track of Turn
    Grid grid;//grid if objects
     ImageView[] pics = new ImageView[row * col]; //ImageView array to display images on the screen

    //The onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        //Getting the id's from the XML file and adding click listener to them
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pics[m] = new ImageView(this);
                setpicStart(pics[m], m);
                pics[m].setId(m);
                //TO DO: add in this code for the onClick and actionListener
                pics[m].setOnClickListener(v -> gridButtonClick(v.getId()));
                g.addView(pics[m]);
                m++;
            }
        }

    }

    //default constructor
    public MainActivity()
    {
        grid=new Grid(this);
        turnWhite=true;
    }

    //Setting up the grid on the screen to display the images
    public void setpicStart(ImageView i, int pos){
        int x = pos/col;
        int y = pos%col;
        String str= grid.getImage(x,y);
        //
        if(str.equals("xxwu"))
            pics[pos].setImageResource(R.drawable.xxwu);
        else if(str.equals("xxbu"))
            pics[pos].setImageResource(R.drawable.xxbu);
        else if(str.equals("xxbs"))
            pics[pos].setImageResource(R.drawable.xxbs);
        else if(str.equals("xxws"))
            pics[pos].setImageResource(R.drawable.xxws);
        else if(str.equals("pwbu"))

            pics[pos].setImageResource(R.drawable.pwbu);
        else if(str.equals("pwwu"))
            pics[pos].setImageResource(R.drawable.pwwu);
        else if(str.equals("pwbs"))
            pics[pos].setImageResource(R.drawable.pwbs);
        else if(str.equals("pwws"))
            pics[pos].setImageResource(R.drawable.pwws);
        else if(str.equals("pbwu"))
            pics[pos].setImageResource(R.drawable.pbwu);
        else if(str.equals("pbbu"))
            pics[pos].setImageResource(R.drawable.pbbu);
        else if(str.equals("pbws"))
            pics[pos].setImageResource(R.drawable.pbws);
        else if(str.equals("pbbs"))
            pics[pos].setImageResource(R.drawable.pbbs);

        else if(str.equals("rwbu"))
            pics[pos].setImageResource(R.drawable.rwbu);
        else if(str.equals("rwwu"))
            pics[pos].setImageResource(R.drawable.rwwu);
        else if(str.equals("rwbs"))
            pics[pos].setImageResource(R.drawable.rwbs);
        else if(str.equals("rwws"))
            pics[pos].setImageResource(R.drawable.rwws);
        else if(str.equals("rbwu"))
            pics[pos].setImageResource(R.drawable.rbwu);
        else if(str.equals("rbbu"))
            pics[pos].setImageResource(R.drawable.rbbu);
        else if(str.equals("rbws"))
            pics[pos].setImageResource(R.drawable.rbws);
        else if(str.equals("rbbs"))
            pics[pos].setImageResource(R.drawable.rbbs);

        else if(str.equals("bwbu"))
            pics[pos].setImageResource(R.drawable.bwbu);
        else if(str.equals("bwwu"))
            pics[pos].setImageResource(R.drawable.bwwu);
        else if(str.equals("bwbs"))
            pics[pos].setImageResource(R.drawable.bwbs);
        else if(str.equals("bwws"))
            pics[pos].setImageResource(R.drawable.bwws);
        else if(str.equals("bbwu"))
            pics[pos].setImageResource(R.drawable.bbwu);
        else if(str.equals("bbbu"))
            pics[pos].setImageResource(R.drawable.bbbu);
        else if(str.equals("bbws"))
            pics[pos].setImageResource(R.drawable.bbws);
        else if(str.equals("bbbs"))
            pics[pos].setImageResource(R.drawable.bbbs);

        else if(str.equals("kwbu"))
            pics[pos].setImageResource(R.drawable.kwbu);
        else if(str.equals("kwwu"))
            pics[pos].setImageResource(R.drawable.kwwu);
        else if(str.equals("kwbs"))
            pics[pos].setImageResource(R.drawable.kwbs);
        else if(str.equals("kwws"))
            pics[pos].setImageResource(R.drawable.kwws);
        else if(str.equals("kbwu"))
            pics[pos].setImageResource(R.drawable.kbwu);
        else if(str.equals("kbbu"))
            pics[pos].setImageResource(R.drawable.kbbu);
        else if(str.equals("kbws"))
            pics[pos].setImageResource(R.drawable.kbws);
        else if(str.equals("kbbs"))
            pics[pos].setImageResource(R.drawable.kbbs);

        else if(str.equals("qwbu"))
            pics[pos].setImageResource(R.drawable.qwbu);
        else if(str.equals("qwwu"))
            pics[pos].setImageResource(R.drawable.qwwu);
        else if(str.equals("qwbs"))
            pics[pos].setImageResource(R.drawable.qwbs);
        else if(str.equals("qwws"))
            pics[pos].setImageResource(R.drawable.qwws);
        else if(str.equals("qbwu"))
            pics[pos].setImageResource(R.drawable.qbwu);
        else if(str.equals("qbbu"))
            pics[pos].setImageResource(R.drawable.qbbu);
        else if(str.equals("qbws"))
            pics[pos].setImageResource(R.drawable.qbws);
        else if(str.equals("qbbs"))
            pics[pos].setImageResource(R.drawable.qbbs);

        else if(str.equals("nwbu"))
            pics[pos].setImageResource(R.drawable.nwbu);
        else if(str.equals("nwwu"))
            pics[pos].setImageResource(R.drawable.nwwu);
        else if(str.equals("nwbs"))
            pics[pos].setImageResource(R.drawable.nwbs);
        else if(str.equals("nwws"))
            pics[pos].setImageResource(R.drawable.nwws);
        else if(str.equals("nbwu"))
            pics[pos].setImageResource(R.drawable.nbwu);
        else if(str.equals("nbbu"))
            pics[pos].setImageResource(R.drawable.nbbu);
        else if(str.equals("nbws"))
            pics[pos].setImageResource(R.drawable.nbws);
        else if(str.equals("nbbs"))
            pics[pos].setImageResource(R.drawable.nbbs);


    }

    //Method that runs on click of button on the Screen
    public void gridButtonClick(int pos) {
        int x = pos / col;
        int y = pos % col;
        ImageView turn = (ImageView) findViewById(R.id.turn);
        int m=grid.doSomething(x,y);
        //Boolean Statements were passed as a 2 digit integer,So making them into single digits and performing actions accordingly
        int k=m/10;
        int l=m%10;
        //Copying the turnWhite variable based on the return value of doSomething method
        if (k==0)
            turnWhite=false;
        else if(k==1)
            turnWhite=true;

        //calls the showPawnSelectionScreen method based on the return value of doSomething method
        if (l==1) {
            showPawnSelectionScreen(x,y);
            redraw();
        }
        //Refreshing the turn Image on the Screen
        if(turnWhite) {
            turn.setImageResource(R.drawable.kwwu);
        }
        else {
            turn.setImageResource(R.drawable.kbbu);
        }
        redraw();
    }

    //Method to show the pawn selection screen i.e. starting a new activity
    public void showPawnSelectionScreen(int x, int y)
    {

        Intent intent = new Intent(this, pawnSelectionScreen.class);
        // Pass the grid data and position to the intent
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        startActivityForResult(intent, REQUEST_CODE);

    }

    //onActivityResult method that runs once button is pressed on the pawnSelectionScreen and it finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Identifies the request code to be matching with the one we Initialized(Here we have a single result code)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            if (data != null) //Checks if there is any data present(to avoid crashing)
            {
                //gets the required and passed data
                char selectedPiece = data.getCharExtra("selectedPiece", ' ');
                int x = data.getIntExtra("x", -1);
                int y = data.getIntExtra("y", -1);
                //converts the pawn into the requested piece after checking there are no default values present in the code
                if (x != -1 && y != -1 && selectedPiece != ' ')
                {
                    grid.getData(x,y).setPiece(selectedPiece);
                    redraw();
                }
            }
        }
    }

    //reset method gets called on pressing the reset button and resets the grid
    public void reset(View view)
    {
        grid=new Grid(this);
        redraw();
    }

    //Redraw method to refresh the images on the grid
    public void redraw ()
    {
        String str;
        int pos = 0;
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                str=grid.getImage(i,j);
                if(str.equals("xxwu"))
                    pics[pos].setImageResource(R.drawable.xxwu);
                else if(str.equals("xxbu"))
                    pics[pos].setImageResource(R.drawable.xxbu);
                else if(str.equals("xxbs"))
                    pics[pos].setImageResource(R.drawable.xxbs);
                else if(str.equals("xxws"))
                    pics[pos].setImageResource(R.drawable.xxws);
                else if(str.equals("pwbu"))

                    pics[pos].setImageResource(R.drawable.pwbu);
                else if(str.equals("pwwu"))
                    pics[pos].setImageResource(R.drawable.pwwu);
                else if(str.equals("pwbs"))
                    pics[pos].setImageResource(R.drawable.pwbs);
                else if(str.equals("pwws"))
                    pics[pos].setImageResource(R.drawable.pwws);
                else if(str.equals("pbwu"))
                    pics[pos].setImageResource(R.drawable.pbwu);
                else if(str.equals("pbbu"))
                    pics[pos].setImageResource(R.drawable.pbbu);
                else if(str.equals("pbws"))
                    pics[pos].setImageResource(R.drawable.pbws);
                else if(str.equals("pbbs"))
                    pics[pos].setImageResource(R.drawable.pbbs);

                else if(str.equals("rwbu"))
                    pics[pos].setImageResource(R.drawable.rwbu);
                else if(str.equals("rwwu"))
                    pics[pos].setImageResource(R.drawable.rwwu);
                else if(str.equals("rwbs"))
                    pics[pos].setImageResource(R.drawable.rwbs);
                else if(str.equals("rwws"))
                    pics[pos].setImageResource(R.drawable.rwws);
                else if(str.equals("rbwu"))
                    pics[pos].setImageResource(R.drawable.rbwu);
                else if(str.equals("rbbu"))
                    pics[pos].setImageResource(R.drawable.rbbu);
                else if(str.equals("rbws"))
                    pics[pos].setImageResource(R.drawable.rbws);
                else if(str.equals("rbbs"))
                    pics[pos].setImageResource(R.drawable.rbbs);

                else if(str.equals("bwbu"))
                    pics[pos].setImageResource(R.drawable.bwbu);
                else if(str.equals("bwwu"))
                    pics[pos].setImageResource(R.drawable.bwwu);
                else if(str.equals("bwbs"))
                    pics[pos].setImageResource(R.drawable.bwbs);
                else if(str.equals("bwws"))
                    pics[pos].setImageResource(R.drawable.bwws);
                else if(str.equals("bbwu"))
                    pics[pos].setImageResource(R.drawable.bbwu);
                else if(str.equals("bbbu"))
                    pics[pos].setImageResource(R.drawable.bbbu);
                else if(str.equals("bbws"))
                    pics[pos].setImageResource(R.drawable.bbws);
                else if(str.equals("bbbs"))
                    pics[pos].setImageResource(R.drawable.bbbs);

                else if(str.equals("kwbu"))
                    pics[pos].setImageResource(R.drawable.kwbu);
                else if(str.equals("kwwu"))
                    pics[pos].setImageResource(R.drawable.kwwu);
                else if(str.equals("kwbs"))
                    pics[pos].setImageResource(R.drawable.kwbs);
                else if(str.equals("kwws"))
                    pics[pos].setImageResource(R.drawable.kwws);
                else if(str.equals("kbwu"))
                    pics[pos].setImageResource(R.drawable.kbwu);
                else if(str.equals("kbbu"))
                    pics[pos].setImageResource(R.drawable.kbbu);
                else if(str.equals("kbws"))
                    pics[pos].setImageResource(R.drawable.kbws);
                else if(str.equals("kbbs"))
                    pics[pos].setImageResource(R.drawable.kbbs);

                else if(str.equals("qwbu"))
                    pics[pos].setImageResource(R.drawable.qwbu);
                else if(str.equals("qwwu"))
                    pics[pos].setImageResource(R.drawable.qwwu);
                else if(str.equals("qwbs"))
                    pics[pos].setImageResource(R.drawable.qwbs);
                else if(str.equals("qwws"))
                    pics[pos].setImageResource(R.drawable.qwws);
                else if(str.equals("qbwu"))
                    pics[pos].setImageResource(R.drawable.qbwu);
                else if(str.equals("qbbu"))
                    pics[pos].setImageResource(R.drawable.qbbu);
                else if(str.equals("qbws"))
                    pics[pos].setImageResource(R.drawable.qbws);
                else if(str.equals("qbbs"))
                    pics[pos].setImageResource(R.drawable.qbbs);

                else if(str.equals("nwbu"))
                    pics[pos].setImageResource(R.drawable.nwbu);
                else if(str.equals("nwwu"))
                    pics[pos].setImageResource(R.drawable.nwwu);
                else if(str.equals("nwbs"))
                    pics[pos].setImageResource(R.drawable.nwbs);
                else if(str.equals("nwws"))
                    pics[pos].setImageResource(R.drawable.nwws);
                else if(str.equals("nbwu"))
                    pics[pos].setImageResource(R.drawable.nbwu);
                else if(str.equals("nbbu"))
                    pics[pos].setImageResource(R.drawable.nbbu);
                else if(str.equals("nbws"))
                    pics[pos].setImageResource(R.drawable.nbws);
                else if(str.equals("nbbs"))
                    pics[pos].setImageResource(R.drawable.nbbs);
                pos++;
            }
        }
    }

    //Method that starts another activity i.e. takes user to another screen
    public void toSecond(View view)
    {
        Intent intent = new Intent(this, OpeningScreen.class);
        startActivity(intent);
    }


}