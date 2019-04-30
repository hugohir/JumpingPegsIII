/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingpegsiii;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author hhira
 */
public class pegBoard {
    
    private int pegBoardSize;
    private int[] pegBoardGame;
    private int[] winBoardGame;
    //private ArrayList<String> pegBoardGame = new ArrayList<String>();
    //private ArrayList<String> winBoardGame = new ArrayList<String>();
  
    
    public pegBoard(int pegL, int pegR)
    {
     pegBoardSize = (pegL + pegR + 1);   
    }
    
    public void setPegBoard(int pegBoardS, int pegL, int pegR, int pegLRV, int pegRLV, int pegSp)
    {
  
        
       pegBoardGame = new int[pegBoardS];
       winBoardGame = new int[pegBoardS];
    
      //  pegBoardGame = new ArrayList<pegBoardS>;
      //  winBoardGame = new ArrayList<pegBoardS>;
        
    
    //left side of array
    for (int j=0; j<pegL;j++)
    {
        pegBoardGame[j]=pegLRV;
        
    }
    
    for (int j=0; j<pegR;j++)
    {
        winBoardGame[j]=pegRLV;
    }

    //right side of array
    for (int k = pegL+1;k<pegBoardS;k++)
    {
        pegBoardGame[k]=pegRLV;
        
    }
    
    for (int k = pegR+1;k<pegBoardS;k++)
    {
        winBoardGame[k]=pegLRV;
    }
    
    pegBoardGame[pegL]=pegSp;
    winBoardGame[pegR]=pegSp;
    }

    public int[] getPegBoard()
    {

        return pegBoardGame;
        

    }

    public int[] getWinBoard()
            {
                return winBoardGame;
            }
    
    public int getBoardSize()
    {
        return pegBoardSize;
        
    }
}
