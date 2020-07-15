//File:     front.java
//Author:   Sushil pandey
//Program:  Assignment4
//Date:     2/19/2019
//Professor:Lee Hanku

//Description
//This file contains the java conversion of front.java
import java.io.*;
import java.util.*;

public class front
{ 
    //Global variable declaration:
    private static int charClass;
    private static char lexeme[];
    private static char nextChar;
    private static int lexLen;
    private static int token;
    private static int nextToken;
    private static File file;
    private static FileInputStream fInputS;
    
    private static final int LETTER=0;
    private static final int DIGIT=1;
    private static final int UNKNOWN=99;
    private static final int EOF=-1;
    private static final int INT_LIT=10;
    private static final int IDENT=11;
    private static final int ASSIGN_OP=20;
    private static final int ADD_OP=21;
    private static final int SUB_OP=22;
    private static final int MULT_OP=23;
    private static final int DIV_OP=24;
    private static final int LEFT_PAREN=25;
    private static final int RIGHT_PAREN=26;

    /***************************************************************
    function lookup
    This function look up the operators and parenthesis  in privoded file.*/
    public static int lookup(char ch)
    {
        switch (ch)
        {
            case '(':
                addChar();
                nextToken = LEFT_PAREN;
                break;
            case ')':
                addChar();
                nextToken = RIGHT_PAREN;
                break;
            case '+':
                addChar();
                nextToken = ADD_OP;
                break;
            case '-':
                addChar();
                nextToken = SUB_OP;
                break;
            case '*':
                addChar();
                nextToken = MULT_OP;
                break;
            case '/':
                addChar();
                nextToken = DIV_OP;
                break;
            default:
                addChar();
                nextToken = EOF;
                break;
        }
        return nextToken;
    }
    /***************************************************************
    //function addChar
    //This function adds the each next character to lexeme and prints the error 
    //message if the length of character is more than 98.*/
    public static void addChar()
    {
            if (lexLen <= 98)
            {
                lexeme[lexLen++] = nextChar;
                lexeme[lexLen] = 0;
            }
            else
            System.out.println("Error -lexeme is too long\n");
    }
    /***************************************************************
    //function getChar
    //This function finds the next character of input and determines its character class.*/
    public static void getChar()
    {
        try
        {
        if(fInputS.available()>0)
        {
            nextChar=(char)fInputS.read();
            if(Character.isLetter(nextChar))
                charClass=LETTER;
            else if(Character.isDigit(nextChar))
                charClass=DIGIT;
            else
                charClass=UNKNOWN;
        }
        else
            charClass=EOF;
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    /***************************************************************
    function getNonBlank
    This function call getChar until it returns a non-whitespace character.*/
    public static void getNonBlank()
    {
        while(Character.isSpaceChar(nextChar))
            getChar();
        
    }
    //This is a simple lexical analyzer for arithematic expressions
    public static int lex()
    {
        lexLen = 0;
            getNonBlank();
            switch (charClass)
            {
            // parse identifiers 
                case LETTER:
                    addChar();
                    getChar();
                    while (charClass == LETTER || charClass == DIGIT)
                    {
                    addChar();
                    getChar();
                }
                    nextToken = IDENT;
                    break;
                    // parse integer literals and integers 
                case DIGIT:
                    addChar();
                    getChar();
                while(charClass == DIGIT)
                {
                        addChar();
                        getChar();
                }
                nextToken = INT_LIT;
                break;
                // parentheses and operators 
                case UNKNOWN:
                    lookup(nextChar);
                    getChar();
                    break;
                //End of file
                case EOF:
                nextToken = EOF;
                lexeme[0] = 'E';
                lexeme[1] = 'O';
                lexeme[2] = 'F';
                lexeme[3] = 0;
                break;

        } // switch statement ends here.
        
        //print statement
        System.out.print("Next token is :"+nextToken+" Next lexeme is ");
        //loop iteration
        
        for(int i=0;i<lexLen+1;i++){
            System.out.print(lexeme[i]);}
        System.out.println();
        return nextToken;
        
    }
   
    
    //main function 
    public static void main(String args[])
    {
        lexLen=0;
        lexeme=new char[100];
        for(int i=0;i<100;i++)
            lexeme[i]='0';
        file = new File("front.in");
        if (!file.exists()) //checks if the file exists
        {
                System.out.println( "file front.in does not exist."); //print of error message 
                return;
        }
      
        //try catch block  
        else{
        try
        {     
                fInputS = new FileInputStream(file);
                char current;
                getChar();
                //do-while loop
                do
                {
                    
                    lex();
                }while (fInputS.available()>0);
                System.out.print("Next token is :-1 Next lexeme is EOF\n");
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
        }
    }
    }
