/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingpegsiii;

/**
 *
 * @author hhira
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.lang.reflect.Array; //for Array.get
/**
 *
 * @author hhira
 */





public class pegEngine {
 
  
    private int pegBoardsz;
    
    private int arrayPegs[];
  //  private int arrayWinPegs[];
  //  private pegBoard winningBoard;
    
    private int pegXq;
    private int pegOq;
    private boolean flagGameEnd=false;
    private int pattern=0;
    private int[] arraySol;
    int[][] arrayLastMoves;
    private int[] arrayMoves;
    private int[] arrayPatternHistory;
    private boolean[]arrayLastPattern;
    int lastValidMove;
   // final int MOVES;
    
    //array to keep track of valid moves
    private boolean[]lastPatternMove;
    private int[] previousArray;
            
    
    //construct array
    public pegEngine(int[] arrayPegIn, int pBoardSize, int pegxQ, int pegoQ)
    {
        pegBoardsz=pBoardSize;
        pegXq = pegxQ;
        pegOq = pegoQ;
        lastValidMove = 0;
     
        for (int m=0;m<pegBoardsz-1;m++)
        {
        
        // set the array to copy and then compare
      
        arrayPegs = new int[pegBoardsz];
        
        }
        
        for (int index=0; index<pegBoardsz;index++)
        {
     
            arrayPegs[index] = arrayPegIn[index];
       }     
    }
   

   
    public int[] solutionArray(int boardSize, int left, int right)
    {
       //ArrayList<String> solArray = new ArrayList<String>();
       
       int[] arraySolution={};
       arraySolution = new int[boardSize];
       
       for (int i =0; i<right;i++)
       {
           arraySolution[i]=2;
       }
       for (int j = right+1;j<boardSize;j++)
       {
           arraySolution[j]=1;
       }
       arraySolution[right]=3;
       
       return arraySolution;
    }
       


public void pegEngineComp()
   {
    
        int pegOCount=0;
        int pegXCount=0;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        int slides=0;
        int jumps=0;
        final int NUMPATTERNS = 5;
        int i;
        int count=0;
        int pat=0;
      //  int[] arraySol;
       // int lastValidMove=-1;
        //create the 2D array list
        //ArrayList<ArrayList<String>> arrayLastMoves = new ArrayList();
       // int last;
     
        //int[][] arrayLastPattern;
        //int[] arrayMoves;
        
      
       
        lastPatternMove = new boolean[NUMPATTERNS];
        previousArray = new int[pegBoardsz];
        arrayPatternHistory = new int[40];
        
        // 2 dimensional array to store:
        // int[move i]
        //int arrayMove[]={};
        //String[] arrayMoves;// = new ArrayList<String>();
        //String[][] arrayMoves={{},{}};
        

        System.out.println("\n-Number of Left Pegs (x|1): "+pegXq);
        System.out.println("-Number of Right Pegs (o|2): "+pegOq);
        
       //ArrayList<String> arrayMoves = new ArrayList<String>();

       //List<int[]> arrayMoveRow = new ArrayList<int[]>();
       
       
        arrayLastMoves = new int[40][pegBoardsz];
        arrayLastPattern = new boolean[NUMPATTERNS]; 
        
       
        arraySol = solutionArray(pegBoardsz,pegXq, pegOq);
        System.out.print("-Solution Peg Gameboard Contents: ");
        
        for (int m=0;m<pegBoardsz;m++)
        System.out.print(arraySol[m]);

        System.out.print("\n");
        boolean answer;
        flag1   =   true;
        flag2   =   true;
        flag3   =   true;
        flag4   =   true;
       // boolean flag = true;
        
        
        lastValidMove =0;
        
        pegXCount = 0;
        pegOCount = 0;
 
        System.out.print("1113222");
        
    
        System.out.print("\n");
        
        do{
                 
            
             count=0;

               
            //check for the case of x_ -> _x  (Pattern 1)
            
           
                for (i = 0; i<pegBoardsz; i++)
                    {
                 
                               
                        if ((( (i<=(pegBoardsz-2)) && arrayPegs[i] == 1) && arrayPegs[i+1] == 3)&& pat!=1 )
                           {

                                //System.out.print("x_ ");
                               
                                pattern=1;
                                
                                //copy the previous arrayPegs status
                                copyPreviousArray(arrayPegs,lastValidMove);
              
                                //swap the pegs contents
                                swapPeg(i, i+1);
                   
                               // System.out.print((lastValidMove+1)+" ");
                      
                                for (int z=0;z<pegBoardsz;z++)
                                    {
                                    
                                        System.out.print(arrayPegs[z]);
                                    }
                        
             //                  System.out.print(" LVM: "+lastValidMove);
                               System.out.print("\n");
                  
                               i=0; 
                
                               flag1 = true;
                 
                               lastValidMove=lastValidMove+1;
                               arrayPatternHistory[lastValidMove]=pattern;

                               lastPatternMove[pattern]=true;
                       
                            }  
                
                        else
                    
                            flag1=false;
                
                    }
           
          
            
          
        
           //check for the case of xo_ -> _ox (Pattern 2)

          
           
                for (i = 0; i<pegBoardsz; i++)
               
                    {
                                       

                        if ((((i<=pegBoardsz-3) && (arrayPegs[i] == 1)&& arrayPegs[i+1] ==2 ) && arrayPegs[i+2]==3 )&&pat!=2)
                           {
 
                               // System.out.print("xo_ ");
                                pattern=2;
    
                                //copy the previous arrayPegs status
                                copyPreviousArray(arrayPegs,lastValidMove);
                    
                                //swap the pegs contents
                                swapPeg(i, i+2);

                               // System.out.print((lastValidMove+1)+" ");

                                for (int z=0;z<pegBoardsz;z++)
                                    {
                                
                                        System.out.print(arrayPegs[z]);
                                    }
                                
          //                      System.out.print(" LVM: "+lastValidMove);
                                System.out.print("\n");
                    
                                //i=0; 
                  
                    
                                flag2 = true;
                  
                                count=count+1;
                                lastPatternMove[pattern]=true;
                                lastValidMove=lastValidMove+1;
                                arrayPatternHistory[lastValidMove]=pattern;

                            } 
            
                        else 
                            
                            flag2=false;
                    }
                
           
                
          
             //check for the case of _o -> o_ (Pattern 3)
               //_o -> o_

                
                  
               for (i = 0; i<pegBoardsz; i++)
               
                    {
   
                        if (((i<=(pegBoardsz-2) && arrayPegs[i]==3) && arrayPegs[i+1]== 2)&&pat!=3)
      
                            {
                                // System.out.print("_o ");

                                 pattern=3;

                                 copyPreviousArray(arrayPegs,lastValidMove);


                                  swapPeg(i,i+1);

                                //  System.out.print((lastValidMove+1)+" ");

                                  for (int z=0;z<pegBoardsz;z++)
                                    {
                                    
                                        System.out.print(arrayPegs[z]);

                                    }
                                    
        //                          System.out.print(" LVM: "+lastValidMove);
                                  System.out.print("\n");
                                 
                                  //i=0;

                                 //flag1 = true;
                                  flag3 = true;
                                  
                                  count=count+1;
                                  lastPatternMove[pattern]=true;
                                  lastValidMove=lastValidMove+1;
                                  arrayPatternHistory[lastValidMove]=pattern;

                             }

                        else 
                 
                            flag3=false;
           

                    }
             


            //_xo  -> ox_
         
         
          
                for (i = 0; i<pegBoardsz; i++)
               
                    {
            
                        if (((((i <= pegBoardsz-3) && arrayPegs[i] == 3) && arrayPegs[i+1] ==1) && arrayPegs[i+2]==2)&& pat!=4)                  

                        {
                      
                               // System.out.print("_xo ");

                                pattern=4;

                                copyPreviousArray(arrayPegs,lastValidMove);

                                swapPeg(i, i+2);

                              //  System.out.print((lastValidMove+1)+" ");

                                for (int z=0;z<pegBoardsz;z++)
                                  {
                                      System.out.print(arrayPegs[z]);

                                  }

         //                       System.out.print(" LVM: "+lastValidMove);
                                System.out.print("\n");

                                //i=0;

                                //flag1 = true;
                                flag4=true;
                                count=count+1;
                                lastPatternMove[pattern]=true;
                                lastValidMove=lastValidMove+1;
                                arrayPatternHistory[lastValidMove]=pattern;

                       }

                        else 
                      
                            flag4=false;

                                   
         //<editor-fold defaultstate="collapsed" desc="comment">


                         //check for completion


                        //  System.out.println("Checking Completion\n");

                        //  for (int a = 0; a<pegBoardsz;a++)
                        //      System.out.print(" | "+a+" | ");

                        //  System.out.print("\n");


                       /*   for (int a =0; a<pegOq; a++) 
                          {
                              System.out.print(" | "+arrayPegs[a]+" | ");

                               if (arrayPegs[a]==2)
                                 {

                                     pegOCount=pegOCount+1;

                                 }
                            }

                          System.out.print(" | "+arrayPegs[pegOq]+" | ");

                          for (int b = pegOq+1; b<pegBoardsz; b++)
                          {
                             System.out.print(" | "+arrayPegs[b]+" | ");

                              if(arrayPegs[b]==1)
                                 {        
                                  pegXCount = pegXCount+1;
                                   //System.out.println("pegXCount = "+pegXCount);

                                 }    
                          }

                         */               
               //</editor-fold>     
                     }

        
            
       
   //         System.out.print("COUNT = "+count);
       /*
            answer=checkValidMoves(lastPatternMove,count);
           
           //System.out.println("ALM should be 1311222");
           for (int x1=0;x1<pegBoardsz;x1++)
               System.out.print(arrayLastMoves[2][x1]);
           
           if (answer==false)
         */
       
   //    System.out.print(" Last Valid Move "+(lastValidMove-1)+" ");
       
         pat=arrayPatternHistory[lastValidMove];
                      
                      //temporary reset of patterns
                //         System.out.println(" Don't Move Pattern: "+pat);
       
       if (count==0)
       {

             //  System.out.println("NO MORE MOVES AS IT IS");
              // for (int n=0; n<pegBoardsz;n++)
              
           
           
           
           
          //    System.out.print(" Flags: ");
         //      for (int f = 1; f<5;f++)
         //      System.out.print(lastPatternMove[f]+" ");
      /*         
               System.out.println("arrayLastMoves 2");
              for (int z3=0;z3<pegBoardsz;z3++)
                  System.out.print(arrayLastMoves[2][z3]);
              System.out.print("\n");
                
              
              System.out.println("arrayLastMoves 1");
              for (int z3=0;z3<pegBoardsz;z3++)
               System.out.print(arrayLastMoves[1][z3]);
                System.out.print("\n");
               
              
              System.out.println("arrayLastMoves 0");
              for (int z3=0;z3<pegBoardsz;z3++)
               System.out.print(arrayLastMoves[0][z3]);
                */
      
         //       System.out.print("\n");
                             
             
                        for (int q1=0; q1<pegBoardsz;q1++)
                   {
            
               //        arrayPegs[n]=arrayLastMoves[lastValidMove][q];
               
                       
                  //      System.out.print("#2 arrayLastMoves["+lastValidMove+"]["+q1+"]"+arrayLastMoves[lastValidMove][q1]);
                        //i=lastValidMove;
                        arrayPegs[q1]= arrayLastMoves[lastValidMove-1][q1];
                        System.out.print(arrayPegs[q1]);
                   }         
                        
                        //don't move arrayPatternHistory[lastValidMove]
                        
                      //  pat=arrayPatternHistory[lastValidMove];
                     // pat=dontMovePattern(lastPatternMove);
             /*        
                     System.out.println("\nPattern History");
                     for (int v7=0;v7<20;v7++)
                     {
                     System.out.println(v7+ " : "+arrayPatternHistory[v7]);
                     
                             }
               */      
                  /*    pat=arrayPatternHistory[lastValidMove];
                      
                      //temporary reset of patterns
                         System.out.println(" Don't Move Pattern: "+pat);
                    */     
           /*
                         
                         
                        System.out.println("arrayPatternHistory");
                        for (int u9=1;u9<20;u9++)
                        {
                            System.out.println(u9+" : "+arrayPatternHistory[u9]);
                                    
                        }
             */           
                        lastValidMove=lastValidMove-1; 
      //                  System.out.println("###Future lastValidMove="+lastValidMove);
      //                 System.out.print("Array Last moves: "+arrayLastMoves[lastValidMove][q]);

        //    System.exit(0);
          
               
                   
          /*        
                   
              System.out.println("Current Array:");
               for (int s=0;s<pegBoardsz;s++)
                   System.out.print(arrayPegs[s]);
            */   
           }
                
                
           // }
            
            
               // System.out.println("");
            try
            {
             System.in.read();

            }
            catch(Exception e)
            {
             e.printStackTrace();
            }         

                //}//for loop
       //     }while (count!=0); //if count is zero there are NO more valid moves so you must go back
            
       //<editor-fold defaultstate="collapsed" desc="comment">
  
       //System.out.println("OUT OF LOOP BECAUSE COUNT = 0");
             //  System.out.println("\nFLAGS: ");
            // System.out.println("F1= "+flag1+", F2= "+flag2+", F3= "+flag3+", F4= "+flag4);

            
         //   System.out.print("Before Calling checkValidMoves- lastPatternMove[1]="+lastPatternMove[1]+" lastPatternMove[2]="+lastPatternMove[2]+" lastPatternMove[3]="+lastPatternMove[3]+" lastPatteernMove[4]="+lastPatternMove[4]);
            
            
     /*       for(int j1=0;j1<4;j1++)
            {
                
            }
           if (((( !flag1 && !flag2) &&!flag3) && !flag4) && i==(pegBoardsz-1))
             {
                 
                System.out.println("All flags are False!");
             }                           
       */         //if #moves >1, then revert to previous change
                // revert should be to before last move
                                   
                // lets move the thing back to the previous move
/*                                   
                if (lastValidMove >0)
                    {
                     arrayPegs[i]=arrayLastMoves[lastValidMove][0];

                             
                     System.out.println("Going backwards to previous move "+lastValidMove);
                   //revert to one movebefore
                    }
                
                for (int f=0;f<pegBoardsz;f++)
                    {
                     System.out.print(arrayPegs[f]);
                    }
                                   
*/

          //   }
/*                               
            System.out.println("\nCOUNTERS: "); 
            System.out.println("\npegOCount= " +pegOCount+ " pegOq= " +pegOq+ " | pegXCount= " + pegXCount +" pegXq= "+pegXq);
*/
//</editor-fold>   
            if ((pegOCount== pegOq) && (pegXCount == pegXq))
                {
                 System.out.println("Solved");
                 System.exit(0);
                }       
                                
        
                 
            
            
        }while ((pegOCount!=pegOq) && (pegXCount != pegXq));
           
        }
    
/*
public int[] getPreviousArray(int[][] arrayML)
{
    
    return arrayLastMove;
    
}
*/

  public /*int[][]*/ void copyPreviousArray(int[] currArray, int lastmov)
    {
        
       // int[][] arrayLastMoves2= new int [40][pegBoardsz];
        
        
       
        
        for (int q=0;q<pegBoardsz;q++)
            {
            
                arrayLastMoves[lastmov][q]=currArray[q];
       //     System.out.print("ArrayLastmove ="+arrayLastMoves2[lastmov][q]);
            }
        
       // System.out.println("Array Last Move: "+lastmov);
    //    for (int index=0;index<pegBoardsz;index++)
    //                       System.out.print("Copying "+arrayLastMoves2[lastmov][index]);
     //                  System.out.println();
        
     //   System.out.println("arrayLastMoves2[3][1]="+arrayLastMoves2[3][0]);
          //  return arrayLastMoves;
    }
             
  
  
  
  public boolean checkValidMoves(boolean[]lastPatMov, int ct)
  {
      boolean inMove;
      
  
    // System.out.println("xo_= "+lastPatMov[1]+" xo_= "+lastPatMov[2]+" _o]= "+lastPatMov[3]+" _xo= "+lastPatMov[4]);

        if((((/*!lastPatMov[1] && */!lastPatMov[2]) && !lastPatMov[3]) && !lastPatMov[4])&& ct == 0)
    {
    System.out.println("No MORE VALID MOVES inside checkValidMoves");
          
        inMove=false;
    }
        else 
    {
        System.out.println("There are MORE VALID MOVES inside checkValidMoves");

        
        inMove=true;
    }   
        
        
        
        return inMove;
             
  }
  
    public int dontMovePattern(boolean[] lastpattern)
    {
        int patdontmove=0;
        
        if (lastpattern[4]==true)
            
            patdontmove=4;
        
         else if(lastpattern[3]==true)
        
        patdontmove=3;
        
        else if (lastpattern[2]==true)
        
        patdontmove=2;
        
        else if (lastpattern[1]==true)

        patdontmove=1;

        return patdontmove;
    }
    
        
    //This method will copy the Previous Valid Move if all current moves are NOTVALID to the current Array
    //by searching the lastValidMove number
    //
    public boolean returnPreviousMove(int[][][] lastValidArray)
    {
       
        int lastPos;
        int lastValMove;
        
        lastPos=lastValidMove;
        lastValMove=pattern;
        
        for (int index=0;index<pegBoardsz;index++)
        arrayPegs[index]=lastValidArray[lastValMove][lastPos][index];
        
        return false;
        
    }
    
    
   public boolean endGame(int[] array1, int[] array2)
   {
       boolean arraysEqual = false;
       int index =0;
       if (array1.length !=  array2.length)
           arraysEqual = false;
       
       while(arraysEqual && index <array1.length )
       {
           if (array1[index] != array2[index])
               arraysEqual = false;
           index++;
       }
   
              
       return arraysEqual;
       
   }
   
    
    public void swapPeg(int peg1, int peg2)
    {
        int temp;
        
        //System.out.println("peg1 index = "+peg1+" peg2 index = "+peg2);
      
               
                
        temp = arrayPegs[peg2];
        arrayPegs[peg2] = arrayPegs[peg1];
        
        
        arrayPegs[peg1] = temp;
       // for (int i = 0; i<pegBoardsz;i++)
       //     System.out.print(arrayPegs[i]);
                    
            
        
    }
   
    
   
    
}
    
    

