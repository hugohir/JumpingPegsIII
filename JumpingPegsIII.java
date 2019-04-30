/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingpegsiii;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


/**
 *
 * @author hhira
 */
public class JumpingPegsIII extends Application {
    
    @Override
   // @Override
    public void start(Stage stage) throws Exception{

        
        
        
        Parent parent = FXMLLoader.load(getClass().getResource("JumpingPegsIII.fxml"));
        
        
        Scene scene = new Scene(parent);
        
        stage.setTitle("JUMPING PEGS III");
        stage.setScene(scene);

        
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        int qtyleftpegs;
        int qtyrightpegs;
        int colorleftpegs;
        int colorrightpegs;
        int typeleftpegs;
        int typerightpegs;
        int boardSize;
        String input;
        char choice;
        pegs gamePegs = null;
        pegBoard gameBoard;
        final int PEGLRVAL = 1;
        final int PEGRLVAL = 2;
        final int PEGSPACE = 3;    
        int[] arrayGame;
        
      
        
        pegEngine simulation;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("WELCOME TO THE JUMPING PEGS SIMULATOR");
        System.out.println("-------------------------------------");
        System.out.println("\nGAME SETUP");
        
        
        System.out.print("\n>>Do you want to customize the game? Y/N: ");
        input = keyboard.nextLine();
        String upper = input.toUpperCase();
        
        choice = upper.charAt(0);
        
        switch(choice)
        {
            case 'N':
            
                gamePegs = new pegs();
                break;
                 
            case 'Y':
            {
                
        
                System.out.print("\n>>Enter number of left pegs: ");
                qtyleftpegs = keyboard.nextInt();

           //     System.out.println("Choose Left pegs color 1-Red, 2-Blue, 3-Yellow: ");
           //     colorleftpegs = keyboard.nextInt();

           //     System.out.println("Choose Left pegs type 1-Peg, 2-Car, 3-boot: ");
           //     typeleftpegs = keyboard.nextInt();



                System.out.print(">>Enter number of right pegs: ");
                qtyrightpegs = keyboard.nextInt();

           //     System.out.println("Choose Right pegs color 1-Red, 2-Blue, 3-Yellow: ");
           //     colorrightpegs = keyboard.nextInt();

          //      System.out.println("Choose Right pegs type 1-Peg, 2-Car, 3-boot: ");
           //     typerightpegs = keyboard.nextInt();


           //     gamePegs = new pegs(qtyleftpegs,qtyrightpegs,colorleftpegs,colorrightpegs,typeleftpegs,typerightpegs);
                gamePegs = new pegs(qtyleftpegs,qtyrightpegs,2,2,PEGLRVAL,PEGRLVAL);
           
           break;
            }   
            
            default:
                      
        }

        
        qtyleftpegs = gamePegs.getPegsLR();
        qtyrightpegs = gamePegs.getPegsRL();
        
        
        
        //next build the boards
        
        gameBoard = new pegBoard(qtyleftpegs, qtyrightpegs);
        
        
        boardSize = gameBoard.getBoardSize();
        System.out.println("-------------------------------------");

        System.out.println("\nInitial Game Configuration");
        System.out.print("\n-Game Board Size                : "+boardSize+"\n");
                   
        gameBoard.setPegBoard(boardSize, qtyleftpegs, qtyrightpegs, PEGLRVAL, PEGRLVAL, PEGSPACE);
       
        arrayGame = gameBoard.getPegBoard();
        
        System.out.print("-Original Peg Gameboard Contents: ");

        for (int z = 0; z<=boardSize-1; z++)
        {
            System.out.print(arrayGame[z]);
        }
        

//run the simulation
       
        simulation = new pegEngine(arrayGame, boardSize, qtyleftpegs, qtyrightpegs);
    

        launch(args);  
        simulation.pegEngineComp();
      
    
        
        
    }
    
}
