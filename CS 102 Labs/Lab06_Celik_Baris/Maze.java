//********************************************************************
//  Maze.java       Author: Lewis/Loftus
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

   private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} };

   //private int[][] grid = {{1,1,1,1,1,1},
     //                      {0,1,1,1,1,1},
       //                    {0,1,0,0,0,0},
         //                  {0,0,0,1,0,1}};
                                          
                           
   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {

     int[] portal = new int[2];
     boolean made = false;
     int i = 0;
     int k = 0;
     boolean done = false;

     if(valid(row, column)){

      if(isPortal(row,column)){

         if(portal(row,column,i,k,portal) != null){
            made = false;
         }

      }

      grid[row][column] =TRIED;
     

         if (row == grid.length-1 && column == grid[0].length-1)
            done = true;  // the maze is solved
         else
         {
            done = traverse (row+1, column);     // down
            if (!done)
               done = traverse (row, column+1);  // right
            if (!done)
               done = traverse (row-1, column);  // up
            if (!done)
               done = traverse (row, column-1);  // left
         }

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }
      
      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }

   

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }


   private boolean isPortal(int row, int column){
      boolean portal = false;

      if(row >=0 && row< grid.length && column>=0 && column < grid[row].length){
         
         if(grid[row][column] != 1 && grid[row][column] != 0 && grid[row][column] != 3 && grid[row][column] != 7){
            portal = true;
         }         
      }
      return portal;
   }



   private int[] portal (int row, int column, int i, int k, int[] portal){
      
      if(grid[i][k] == grid[row][column] && (i != row || k!= column)){
         portal[0]=i;
         portal[k]=k;
         return portal;
      }

      else {
         if(i + 1 < grid.length) {
            return portal(row,column,i + 1,k, portal);
         }

         else if(k+1 < grid[i].length){
            i = 0;
            return portal(row,column,i, k + 1,portal);
         }
      }

      return portal;
   }
}
