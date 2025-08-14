//Name: Harkaran Gill
//Date: 17 June 2024
//Purpose: An ADT Class of the Minion Chess final project used to deal with the grid functioning

package com.example.MinionChess;
import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

public class Grid implements Serializable {
    private int count;//counter variable that's used in if statement to decides if to execute move function or select
    private Piece[][] data =new Piece[8][8];//main grid array
    private Piece[][] dataCopy =new Piece[8][8];//copy of the grid array
    private Piece lastPlayed;//keeps record of the current/last played piece
    private final int row;//Rows
    private final int col;//Columns
    private boolean turnWhite;//Keeps record of whether it is
    private boolean onlyKingCanMove;//This value is true when under Check, if true only King can move
    private Context context;//Keeps context of the main class (to make toast as Grid class does not have its own screen)
    char[][] pieceCopy = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};

    char[][] selectCopy = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
            {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
            {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
            {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

    char[][] colourCopy = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

    char[][] bgCopy = {{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
            {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
            {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
            {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'}};

    //Default Constructor
    public Grid()
    {
        initialize();
        count=0;
        turnWhite=true;
        row=8;
        col=8;
        onlyKingCanMove=false;
    }

    //Custom constructor
    public Grid(Context context)
    {
        initialize();
        count=0;
        turnWhite=true;
        row=8;
        col=8;
        onlyKingCanMove=false;
        this.context=context;
    }

    //This method Initializes the gird
    public void initialize()
    {
        char[][] piece = {{'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}, {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'}};

        char[][] select = {{'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
                {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
                {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'},
                {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}, {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u'}};

        char[][] colour = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}};

        char[][] bg = {{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
                {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
                {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'},
                {'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w'}, {'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b'}};

        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece p= new Piece(piece[i][j],select[i][j],colour[i][j],bg[i][j],i ,j);
                push(p);
            }
        }
    }

    //This method is used to select the Pieces of the opposite colour after Check(Does not affect the screen only to find out where the King can move)
    public void selectCheck(int x, int y)
    {
        if(data[x][y].getColour()=='w')//Check if piece is White
        {
            if(data[x][y].getPiece()=='p')//Checks if its a pawn and selects it's kill blocks(Diagonal Fronts)
            {
                if(data[x][y].getColour()=='w'){
                    if(x+1<row&&y+1<col)
                    {
                        data[x+1][y+1].setSelect('s');
                    }
                    if(x+1<row&&y-1>=0)
                    {
                        data[x+1][y-1].setSelect('s');
                    }
                }
            }
            if(data[x][y].getPiece()=='b'||data[x][y].getPiece()=='r'||data[x][y].getPiece()=='q')//Checks if it is BISHOP, QUEEN or ROOK
            {
                if(data[x][y].getPiece()=='r'||data[x][y].getPiece()=='q')//Checks if it is a ROOK or a QUEEN and selects in Straight lines
                {
                    for (int i=x+1;i<row;i++)
                    {
                        if(selectBRQ(i,y,'w'))
                            break;
                    }

                    for (int i=x-1;i>=0;i--)
                    {
                        if(selectBRQ(i,y,'w'))
                            break;
                    }

                    for (int j=y+1;j<col;j++)
                    {
                        if(selectBRQ(x,j,'w'))
                            break;
                    }

                    for (int j=y-1;j>=0;j--)
                    {
                        if(selectBRQ(x,j,'w'))
                            break;
                    }
                }
                if(data[x][y].getPiece()=='q'||data[x][y].getPiece()=='b')//Checks if it is a BISHOP or a QUEEN and selects the diagonals
                {
                    selectBQ(x, y, 'w');
                }
            }
            if(data[x][y].getPiece()=='n')//Checks if it is a KNIGHT and executes the appropriate method
            {
                selectKnight(x,y,'w');
            }
        }

        //EVERYTHING is same EXCEPT it selects Black Pieces, so the Parameters may vary
        else if(data[x][y].getColour()=='b')
        {
            if(data[x][y].getPiece()=='p')
            {
                if(x-1>=0 && y-1>=0 )
                {
                    data[x-1][y-1].setSelect('s');
                }
                if(x-1>=0 && y+1<col)
                {
                    data[x-1][y+1].setSelect('s');
                }
            }
            if(data[x][y].getPiece()=='b'||data[x][y].getPiece()=='r'||data[x][y].getPiece()=='q')
            {
                if(data[x][y].getPiece()=='r'||data[x][y].getPiece()=='q')
                {
                    for (int i=x+1;i<row;i++)
                    {
                        if(selectBRQ(i,y,'b'))
                            break;
                    }

                    for (int i=x-1;i>=0;i--)
                    {
                        if(selectBRQ(i,y,'b'))
                            break;
                    }

                    for (int j=y+1;j<col;j++)
                    {
                        if(selectBRQ(x,j,'b'))
                            break;
                    }

                    for (int j=y-1;j>=0;j--)
                    {
                        if(selectBRQ(x,j,'b'))
                            break;
                    }
                }
                if(data[x][y].getPiece()=='q'||data[x][y].getPiece()=='b')
                {
                    selectBQ(x,y,'b');
                }
            }
            if(data[x][y].getPiece()=='n')
            {
                selectKnight(x,y,'b');
            }
        }
    }

    //Select Method used for normal Selection
    public void select(int x, int y)
    {
        lastPlayed=data[x][y];
        // Checking if it's White's turn and if White Piece is being pressed
        if(lastPlayed.getColour()=='w'&&turnWhite)
        {
            count++;
            //Checks if the element id a Pawn and the body Selects area where PAWN can go
            if(lastPlayed.getPiece()=='p')
            {
                if(x+1<row&&data[x+1][y].getPiece()=='x')
                {
                    data[x+1][y].setSelect('s');
                    if(x+2<row&&x==1&&data[x+2][y].getPiece()=='x'){
                        data[x+2][y].setSelect('s');
                    }
                    System.out.println("Selection Executing");
                }
                //White Pawn Kill Black.... Checks if the front two diagonals have a Piece that can be killed
                if(x+1<row&&y+1<col&&data[x+1][y+1].getPiece()!='x'&&data[x+1][y+1].getColour()=='b')
                {
                    data[x+1][y+1].setSelect('s');
                }
                if(x+1<row&&y-1>=0&&data[x+1][y-1].getPiece()!='x'&&data[x+1][y-1].getColour()=='b')
                {
                    data[x+1][y-1].setSelect('s');
                }
            }
            //Checks if the Piece if QUEEN, ROOK or BISHOP  (White)
            else if(lastPlayed.getPiece()=='r'||lastPlayed.getPiece()=='q'||lastPlayed.getPiece()=='b')
            {
                //Checks if the Piece if QUEEN or ROOK and Selects the STRAIGHTS
                if(lastPlayed.getPiece()=='r'||lastPlayed.getPiece()=='q')
                {
                    for (int i=x+1;i<row;i++)
                    {
                        if(selectBRQ(i,y,'w'))
                            break;
                    }

                    for (int i=x-1;i>=0;i--)
                    {
                        if(selectBRQ(i,y,'w'))
                            break;
                    }

                    for (int j=y+1;j<col;j++)
                    {
                        if(selectBRQ(x,j,'w'))
                            break;
                    }

                    for (int j=y-1;j>=0;j--)
                    {
                        if(selectBRQ(x,j,'w'))
                            break;
                    }
                }

                //Checks if the piece is QUEEN or BISHOP and executes method to Select the DIAGONALS
                if(lastPlayed.getPiece()=='q'||lastPlayed.getPiece()=='b')
                {
                    selectBQ(x,y,'w');
                }
            }
            //Checks if it is a Knights and executes a method to select it
            else if(lastPlayed.getPiece()=='n')
            {
                selectKnight(x,y,'w');
            }
            //Checks if the Piece is King and Selects Accordingly
            else if(lastPlayed.getPiece()=='k')
            {
                for(int i=0;i<row;i++)
                {
                    for(int j=0;j<col;j++)
                    {
                        if(data[i][j].getColour()=='b')
                            selectCheck(i,j);
                    }
                }
                copyArray();
                unselect();
                selectKing(x,y,'w',true,true);
            }
        }

        //Checking if it's Black's turn and if Black Piece is being pressed
        //More or less the same except the Parameters
        else if(lastPlayed.getColour()=='b'&&!this.turnWhite)
        {
            count++;
            if(lastPlayed.getPiece()=='p')
            {
                if(x-1>=0 &&data[x-1][y].getPiece()=='x')
                {
                    data[x-1][y].setSelect('s');
                    if(x-2>=0 &&x==6&data[x-2][y].getPiece()=='x'){
                        data[x-2][y].setSelect('s');
                    }

                }
                //Black Pawn, Kills White.... Checks if the front two diagonals have a Piece that can be killed
                if(x-1>=0 && y-1>=0 &&data[x-1][y-1].getPiece()!='x'&&data[x-1][y-1].getColour()=='w')
                {
                    data[x-1][y-1].setSelect('s');
                }
                if(x-1>=0 && y+1<col &&data[x-1][y+1].getPiece()!='x'&&data[x-1][y+1].getColour()=='w')
                {
                    data[x-1][y+1].setSelect('s');
                }
            }

            //Checks if piece is ROOK, QUEEN AND BISHOP
            else if(lastPlayed.getPiece()=='r'||lastPlayed.getPiece()=='q'||lastPlayed.getPiece()=='b')
            {
                //Selection of HORIZONTALS and VERTICALS of QUEEN and ROOK
                if(lastPlayed.getPiece()=='r'||lastPlayed.getPiece()=='q')
                {
                    for (int i=x+1;i<row;i++)
                    {
                        if(selectBRQ(i,y,'b'))
                            break;
                    }

                    for (int i=x-1;i>=0;i--)
                    {
                        if(selectBRQ(i,y,'b'))
                            break;
                    }

                    for (int j=y+1;j<col;j++)
                    {
                        if(selectBRQ(x,j,'b'))
                            break;
                    }

                    for (int j=y-1;j>=0;j--)
                    {
                        if(selectBRQ(x,j,'b'))
                            break;
                    }
                }

                //Checks if the Piece is QUEEN or BISHOP and selects the DIAGONALS
                if(lastPlayed.getPiece()=='q'||lastPlayed.getPiece()=='b')
                {
                    selectBQ(x,y,'b');
                }
            }
            //Checks if it is a Knights and executes a method to select it
            else if(lastPlayed.getPiece()=='n')
            {
                selectKnight(x,y,'b');
            }
            //Checks if the Piece is King and Selects Accordingly
            else if(lastPlayed.getPiece()=='k')
            {
                for(int i=0;i<row;i++)
                {
                    for(int j=0;j<col;j++)
                    {
                        if(data[i][j].getColour()=='b')
                            selectCheck(i,j);
                    }
                }
                copyArray();
                unselect();
                selectKing(x,y,'b',true,true);
            }
        }
    }

    //Method that is used to Select the DIAGONALS for BISHOP and QUEEN
    public void selectBQ(int x, int y, char c)
    {
        int i=x+1;
        int j=y+1;
        while(i<row&&j<col)
        {
            if(selectBRQ(i,j,c))
                break;
            i++;
            j++;
        }
        i=x-1;
        j=y-1;
        while(i>=0&&j>=0)
        {
            if(selectBRQ(i,j,c))
                break;
            i--;
            j--;
        }
        i=x-1;
        j=y+1;
        while(i>=0&&j<col)
        {
            if(selectBRQ(i,j,c))
                break;
            i--;
            j++;
        }
        i=x+1;
        j=y-1;
        while(i<row&&j>=0)
        {
            if(selectBRQ(i,j,c))
                break;
            i++;
            j--;
        }
    }

    //Selects for BISHOP, QUEEN or the ROOK
    //It selects the individual pieces unlike selectBQ method that has a for loop and selects everything
    public boolean selectBRQ(int i,int j,char c)
    {
        boolean brake =false;
        if(c=='b')
        {
            if(data[i][j].getColour()=='b')
            {
                brake=true;
            }
            else if(data[i][j].getColour()=='w')
            {
                data[i][j].setSelect('s');
                brake=true;
            }
            else
                data[i][j].setSelect('s');
        }
        else if(c=='w')
        {
            if(data[i][j].getColour()=='w')
            {
                brake=true;
            }
            else if(data[i][j].getColour()=='b')
            {
                data[i][j].setSelect('s');
                brake=true;
            }
            else
                data[i][j].setSelect('s');
        }
        return brake;
    }

    //Method used to select Blocks where the KNIGHT can go
    public void selectKnight(int x, int y,char C)
    {
        if (x-2>=0)
        {
            if(y-1>=0 && data[x-2][y-1].getColour()!=C)
                data[x-2][y-1].setSelect('s');
            if(y+1<col && data[x-2][y+1].getColour()!=C)
                data[x-2][y+1].setSelect('s');
        }
        if(x+2<row)
        {
            if(y-1>=0 && data[x+2][y-1].getColour()!=C)
                data[x+2][y-1].setSelect('s');
            if(y+1<col && data[x+2][y+1].getColour()!=C)
                data[x+2][y+1].setSelect('s');
        }
        if(y-2>=0)
        {
            if(x-1>=0 && data[x-1][y-2].getColour()!=C)
                data[x-1][y-2].setSelect('s');
            if(x+1<row && data[x+1][y-2].getColour()!=C)
                data[x+1][y-2].setSelect('s');
        }
        if(y+2<col)
        {
            if(x-1>=0 && data[x-1][y+2].getColour()!=C)
                data[x-1][y+2].setSelect('s');
            if(x+1<row && data[x+1][y+2].getColour()!=C)
                data[x+1][y+2].setSelect('s');
        }
    }

    //A method that locates the KING and calls the Check method
    public void callCheck()
    {
        for(int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                if(data[i][j].getPiece()=='k'&&data[i][j].getColour()=='w')
                    check(i,j,'w');
            }
        }

        for(int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                if(data[i][j].getPiece()=='k'&&data[i][j].getColour()=='b')
                    check(i,j,'b');
            }
        }
    }

    //Method used to find out if Either of the KING is under CHECK
    public void check(int x,int y,char C)
    {
        //Checks if KING is White and selects the places where the Black pieces can go on the Grid using selectCheck() method
        if(C=='w')
        {
            for(int i=0;i<row;i++)
            {
                for (int j=0;j<col;j++)
                {
                    if(data[i][j].getColour()=='b')
                        selectCheck(i,j);
                }
            }
        }

        //Checks if KING is Black and selects the places where the White pieces can go on the Grid using selectCheck() method
        else if(C=='b')
        {
            for(int i=0;i<row;i++)
            {
                for (int j=0;j<col;j++)
                {
                    if(data[i][j].getColour()=='w')
                        selectCheck(i,j);
                }
            }
        }
        //Checks if
        if(data[x][y].getSelect()=='s')
        {
            onlyKingCanMove=true;
            copyArray();
            unselect();
            if(isCheckMate(x,y,C))
            {
                if(C=='w')
                {
                    Toast.makeText(context,"CHECKMATE!!!! White Lost", Toast.LENGTH_SHORT).show();
                }
                else if(C=='b')
                {
                    Toast.makeText(context,"CHECKMATE!!!! Black Lost", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                if(C=='w')
                {
                    Toast.makeText(context,"CHECK!!!! White needs to move its King", Toast.LENGTH_SHORT).show();
                }
                else if(C=='b')
                {
                    Toast.makeText(context,"CHECK!!!! Black needs to move its King", Toast.LENGTH_SHORT).show();
                }
            }

        }


        unselect();
    }

    //Checks if it's a Checkmate
    public boolean isCheckMate(int x,int y,char c)
    {
        return selectKing(x,y,c,false,false);
    }

    //Displays the Array
    public void checkArray()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                System.out.print(i+" "+j+"  "+getImage(i,j)+"  ");
            }
            System.out.println();
        }
    }

    //Copies the Main array into the dataCopy Array
    public void copyArray()
    {
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                dataCopy[i][j]=new Piece(data[i][j]);
            }
        }
    }

    //method used to select pieces where King can go
    public boolean selectKing(int x, int y,char C,boolean unselect,boolean canCastle)
    {
        int counter=0;
        if(data[x][y].getColour()==C)
        {
            if(x-1>=0)
            {
                if(data[x-1][y].getColour()!=C&&!dataCopy[x+1][y].isSelected())
                {
                    if(x+1<row&&!dataCopy[x+1][y].isSelected()&&!dataCopy[x-1][y].isSelected())
                    {
                        if(dataCopy[x][y].getColour() == dataCopy[x + 1][y].getColour() ||(dataCopy[x+1][y].getPiece()!='q'&&dataCopy[x+1][y].getPiece()!='r'))
                        {
                            data[x-1][y].setSelect('s');
                            counter++;
                        }
                    }
                    else if(x+1>=row&&!dataCopy[x-1][y].isSelected())
                    {
                        data[x-1][y].setSelect('s');
                        counter++;
                    }
                }
                if(y-1>=0 && data[x-1][y-1].getColour()!=C)
                {
                    if(x+1<row&&y+1<col&&!dataCopy[x+1][y+1].isSelected()&&!dataCopy[x-1][y-1].isSelected())
                    {
                        data[x-1][y-1].setSelect('s');
                        counter++;
                    }
                    else if(x+1>=row||y+1>=col&&!dataCopy[x-1][y-1].isSelected())
                    {
                        data[x-1][y-1].setSelect('s');
                        counter++;
                    }
                }

                if(y+1<col && data[x-1][y+1].getColour()!=C)
                {
                    if(x+1<row&&y-1>=0&&!dataCopy[x+1][y-1].isSelected()&&!dataCopy[x-1][y+1].isSelected())
                    {
                        data[x-1][y+1].setSelect('s');
                        counter++;
                    }
                    else if(x+1>=row||y-1<0&&!dataCopy[x-1][y+1].isSelected())
                    {
                        data[x-1][y+1].setSelect('s');
                        counter++;
                    }
                }

            }

            if(x+1<row)
            {
                if(data[x+1][y].getColour()!=C)
                {
                    if(x-1>=0&&!dataCopy[x-1][y].isSelected()&&!dataCopy[x+1][y].isSelected())
                    {
                        if(dataCopy[x][y].getColour() == dataCopy[x - 1][y].getColour() ||(dataCopy[x-1][y].getPiece()!='q'&&dataCopy[x-1][y].getPiece()!='r'))
                        {
                            data[x+1][y].setSelect('s');
                            counter++;
                        }
                    }
                    else if(x-1<0&&!dataCopy[x+1][y].isSelected())
                    {
                        data[x+1][y].setSelect('s');
                        counter++;
                    }
                }

                if(y-1>=0 && data[x+1][y-1].getColour()!=C)
                {
                    if(x-1>=0&&y+1<col&&!dataCopy[x-1][y+1].isSelected()&&!dataCopy[x+1][y-1].isSelected())
                    {
                        data[x+1][y-1].setSelect('s');
                        counter++;
                    }
                    else if(x-1<0||y+1>=col&&!dataCopy[x+1][y-1].isSelected())
                    {
                        data[x+1][y-1].setSelect('s');
                        counter++;
                    }
                }
                if(y+1<col && data[x+1][y+1].getColour()!=C)
                {
                    if(x-1>=0&&y-1>=0&&!dataCopy[x-1][y-1].isSelected()&&!dataCopy[x+1][y+1].isSelected())
                    {
                        data[x+1][y+1].setSelect('s');
                        counter++;
                    }
                    else if(x-1<0||y-1<0&&!dataCopy[x+1][y+1].isSelected())
                    {
                        data[x+1][y+1].setSelect('s');
                        counter++;
                    }
                }
            }

            if(y-1>=0)
            {
                if(data[x][y-1].getColour()!=C)
                {
                    if(y+1<col&&!dataCopy[x][y+1].isSelected()&&!dataCopy[x][y-1].isSelected())
                    {
                        if(dataCopy[x][y].getColour() == dataCopy[x][y + 1].getColour() ||(dataCopy[x][y+1].getPiece()!='q'&&dataCopy[x][y+1].getPiece()!='r'))
                        {
                            data[x][y-1].setSelect('s');
                            counter++;
                        }
                    }
                    else if(y+1>=col&&!dataCopy[x][y-1].isSelected())
                    {
                        data[x][y-1].setSelect('s');
                        counter++;
                    }
                }
            }

            if(y+1<col)
            {
                if(data[x][y+1].getColour()!=C)
                {
                    if(y-1>=0&&!dataCopy[x][y+1].isSelected()&&!dataCopy[x][y+1].isSelected())
                    {
                        if((dataCopy[x][y].getColour()==dataCopy[x][y-1].getColour())||(dataCopy[x][y-1].getPiece()!='q'&&dataCopy[x][y-1].getPiece()!='r'))
                        {
                            data[x][y+1].setSelect('s');
                            counter++;
                        }
                    }
                    else if(y-1<0&&!dataCopy[x][y+1].isSelected())
                    {
                        data[x][y+1].setSelect('s');
                        counter++;
                    }
                }
            }
        }
        if(canCastle)
        {
            if(data[x][y].getColour()=='w'&&!data[x][y].getHasMoved())
            {
                if((!data[0][7].getHasMoved())&&data[0][6].getPiece()=='x'&&data[0][5].getPiece()=='x'&&data[0][4].getPiece()=='x')
                {
                    data[0][5].setSelect('s');
                }
                if((!data[0][0].getHasMoved())&&data[0][1].getPiece()=='x'&&data[0][2].getPiece()=='x')
                {
                    data[0][1].setSelect('s');
                }
            }
            else if(data[x][y].getColour()=='b'&&!data[x][y].getHasMoved())
            {
                if((!data[7][7].getHasMoved())&&data[7][6].getPiece()=='x'&&data[7][5].getPiece()=='x'&&data[7][4].getPiece()=='x')
                {
                    data[7][5].setSelect('s');
                }
                if((!data[7][0].getHasMoved())&&data[7][1].getPiece()=='x'&&data[7][2].getPiece()=='x')
                {
                    data[7][1].setSelect('s');
                }
            }
        }
        if(unselect&&dataCopy!=null)
        {
            unselectCopy();
        }
        return counter == 0;

    }

    //Method used to move a Piece to the Selected block
    public void move(int x, int y)
    {
        data[x][y].setPiece(lastPlayed.getPiece());
        data[x][y].setColour(lastPlayed.getColour());
        if(lastPlayed.getPiece()=='k'&&x==0&&y==5)
        {
            data[0][7].setPiece('x');
            data[0][7].setColour('x');
            data[0][4].setPiece('r');
            data[0][4].setColour('w');
        }

        if(lastPlayed.getPiece()=='k'&&x==0&&y==1)
        {
            data[0][0].setPiece('x');
            data[0][0].setColour('x');
            data[0][2].setPiece('r');
            data[0][2].setColour('w');
        }

        if(lastPlayed.getPiece()=='k'&&x==7&&y==1)
        {
            data[7][0].setPiece('x');
            data[7][0].setColour('x');
            data[7][2].setPiece('r');
            data[7][2].setColour('b');
        }

        if(lastPlayed.getPiece()=='k'&&x==7&&y==7)
        {
            data[7][0].setPiece('x');
            data[7][0].setColour('x');
            data[7][4].setPiece('r');
            data[7][4].setColour('b');
        }
        lastPlayed.setPiece('x');
        lastPlayed.setColour('x');
        count--;
        if(onlyKingCanMove)
        {
            onlyKingCanMove=false;
        }
        lastPlayed.setHasMoved(true);
    }

    //Method that unselects the data array
    public void unselect()
    {
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                data[i][j].setSelect('u');
            }
        }
    }

    //Method that unselects the dataCopy array
    public void unselectCopy()
    {
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                dataCopy[i][j].setSelect('u');
            }
        }
    }

    //The main method that has all the if Statements and deals with Main class
    public int doSomething(int x, int y)
    {
        //Checks if it is the first time a Block being pressed and it's not an Empty Piece
        if(count==0&&data[x][y].getPiece()!='x')
        {
            //For Selection of King when under Check
            if(onlyKingCanMove)
            {
                if(data[x][y].getPiece()=='k'&&data[x][y].getColour()==(turnWhite? 'w':'b'))
                {
                    count++;
                    lastPlayed=data[x][y];
                    selectKing(x,y,data[x][y].getColour(),true,false);
                }
                else
                {
                    Toast.makeText(context,"You Can Only Move The King", Toast.LENGTH_SHORT).show();
                }
            }
            //For all other cases of selection
            else {
                select(x, y);
            }
        }
        //Checks if it is the second press of a Block and executes the move method and is responsible for Castling as well
        else if(count==1&&!lastPlayed.equals(data[x][y])&&data[x][y].getSelect()=='s')
        {
            move(x,y);
            turnWhite=!turnWhite;
            unselect();
            if(getData(x,y).getPiece()=='p')
            {

                if(getData(x,y).getColour()=='w'&&x==7)
                {
                    if(turnWhite)
                        return 11;
                    else
                        return 01;
                }
                else if(getData(x,y).getColour()=='b'&&x==0)
                {
                    if(turnWhite)
                        return 11;
                    else
                        return 01;
                }
            }
            callCheck();
        }
        //Same as else if statement below except checks if onlyKingCanMove is true and the Button press is not valid
        else if(count==1&&!(lastPlayed.equalsSpecial(data[x][y]))&&data[x][y].getSelect()=='u'&&data[x][y].getPiece()!='x'&&onlyKingCanMove)
        {
            Toast.makeText(context,"You Can Only Move The King", Toast.LENGTH_SHORT).show();
        }
        //Checks if it is the second time a Block is being pressed and in case it is a different block that is NOT Empty
        else if(count==1&&!(lastPlayed.equalsSpecial(data[x][y]))&&data[x][y].getSelect()=='u'&&data[x][y].getPiece()!='x')
        {
            unselect();
            count--;
            select(x,y);
        }
        //Same as else if statement below except checks if onlyKingCanMove is true and the Button press is not valid
        else if(count==1&&!(lastPlayed.equalsSpecial(data[x][y]))&&data[x][y].getSelect()=='u'&&data[x][y].getPiece()=='x'&&onlyKingCanMove)
        {
            Toast.makeText(context,"You Can Only Move The King", Toast.LENGTH_SHORT).show();

        }
        //Checks if it is the second time a Block is being pressed and in case it is a different block that is Empty
        else if(count==1&&!(lastPlayed.equalsSpecial(data[x][y]))&&data[x][y].getSelect()=='u'&&data[x][y].getPiece()=='x')
        {
            unselect();
            count--;
            System.out.println("4th If statement executing");
        }
        //Same as else if statement below except checks if onlyKingCanMove is true and the Button press is not valid
        else if(count==1&&lastPlayed.equalsSpecial(data[x][y])&&data[x][y].getPiece()=='k'&&onlyKingCanMove)
        {
            Toast.makeText(context,"You Can Only Move The King", Toast.LENGTH_SHORT).show();

        }
        //Checks if it is the second time a Block is being pressed and its the same Block
        else if(count==1&&lastPlayed.equalsSpecial(data[x][y]))
        {
            unselect();
            count--;
            System.out.println("5th If statement executing");
        }
        if(turnWhite)
            return 10;
        else
            return 00;
    }

    //Displays the copies array(Testing feature)
    public void checkArrayCopy()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                System.out.print(i+" "+j+"  "+getImageOfCopy(i,j)+"  ");
            }
            System.out.println();
        }
    }

    //Push method to push a piece into the data array
    public void push(Piece addMe)
    {
        data[count/8][count%8]=addMe;
        count++;
    }

    //Method to get Piece on given set of Coordinates
    public Piece getData(int x,int y)
    {
        return data[x][y];
    }

    //Method to set Piece on given set of Coordinates
    public void setData(int x,int y, Piece d)
    {
        data[x][y]=d;
    }

    //method that returns Size of stack
    public int size() {
        return count;
    }

    //method that returns if the stack is full or empty
    public boolean isFull() {
        return (count == 64);
    }

    //method that returns true if stack is empty
    public boolean isEmpty() {
        return count == 0;
    }

    //method to clear the stack
    public void clear() {
        count = 0;
    }
    //returns value of Piece from data array at given Coordinates that can be used to display Image
    public String getImage(int x,int y)
    {
        return data[x][y].toString();
    }

    //returns value of Piece from dataCopy array at given Coordinates that can be used to display Image
    public String getImageOfCopy(int x,int y)
    {
        return dataCopy[x][y].toString();
    }
}

