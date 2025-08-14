//Name: Harkaran Gill
//Date: 17 June 2024
//Purpose: An Object Class of the Minion Chess final project that stores everything related to Pieces on the grid
package com.example.MinionChess;

import java.io.Serializable;

public class Piece implements Serializable
{
    private char piece;//Stores the type of Piece
    private char select;//Stores if the  Block is selected
    private char colour;///Stores the colour of the Piece
    private char bg;//Stores the background Colour of the Piece
    private int xCord;//Stores the row the Piece is in
    private int yCord;//Stores the column the method is in
    private boolean hasMoved;//Stores if the Piece has been moved

    //Default Constructor
    public Piece()
    {
        piece='p';
        select='u';
        colour='w';
        bg='w';
        xCord=0;
        yCord=0;
        hasMoved=false;
    }

    //Custom Constructor #1
    public Piece(char p, char s, char c, char b,int i, int j)
    {
        piece=p;
        select= s;
        colour= c;
        bg=b;
        xCord=i;
        yCord=j;
        hasMoved=false;
    }

    //Custom Constructor #2
    public Piece(Piece p)
    {
        piece=p.getPiece();
        select=p.getSelect();
        colour=p.getColour();
        bg=p.getBg();
        xCord=p.getXCord();
        yCord=p.getYCord();
    }

    //returns the value of piece variable
    public char getPiece()
    {
        return piece;
    }

    //returns the value of select variable
    public char getSelect()
    {
        return select;
    }

    //returns the value of colour variable
    public char getColour()
    {
        return colour;
    }

    // returns the value of the bg variable
    public char getBg()
    {
        return bg;
    }

    // returns the value of the xCord variable
    public int getXCord()
    {
        return xCord;
    }

    //returns the value of the yCord variable
    public int getYCord()
    {
        return yCord;
    }

    //returns the value of the has moved variable
    public boolean getHasMoved()
    {
        return hasMoved;
    }

    //returns true if the Piece is selected
    public boolean isSelected()
    {
        if(select=='s')
            return true;
        else
            return false;
    }

    //sets the piece variable
    public void setPiece(char p)
    {
        piece=p;
    }

    //sets the select variable
    public void setSelect(char s)
    {
        select=s;
    }

    //sets the colour variable
    public void setColour(char c)
    {
        colour=c;
    }

    //sets the bg variable
    public void setBg(char b)
    {
        bg=b;
    }

    //sets the hasMoved variable
    public void setHasMoved(boolean m)
    {
        hasMoved=m;
    }

    //toString accessor
    public String toString()
    {
        return ""+piece+""+colour+""+bg+""+select;
    }

    //equals facilitator
    public boolean equals(Piece p)
    {
        if(p.getPiece()==piece&&p.getSelect()==select&&p.getColour()==colour&&p.getBg()==bg)
            return true;
        else
            return false;
    }

    //custom equals method
    public boolean equalsSpecial(Piece p)
    {
        if(p.getPiece()==piece&&p.getSelect()==select&&p.getColour()==colour&&p.getBg()==bg&&xCord==p.getXCord()&&yCord==p.getYCord())
            return true;
        else
            return false;
    }
}