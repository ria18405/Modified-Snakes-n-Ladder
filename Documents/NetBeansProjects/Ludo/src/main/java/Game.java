/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */
import java.util.*;
public class Game {
    static int roll_count=0;
    static int tileno=1;
//    static ArrayList <Tile> path=new ArrayList<Tile>();
    public static void main(String [] args){
        
        Scanner Sc=new Scanner(System.in);
        System.out.print(">>Enter total number of tiles on the race track (length)\n" );
        int tracks=4;
        try{
            tracks=Sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Please enter an integer");
            return;
        }
        
        int [] number_tiles=new int[4];
        int [] score_tiles=new int[4];
        int [] patharray=new int[tracks];
        Random r=new Random();
        for(int i=0;i<4;i++){
            number_tiles[i]=r.nextInt(tracks/4)+1;
        }
        for(int i=0;i<4;i++){
            score_tiles[i]=r.nextInt(10)+1;
        }
        //race track:
        int randomno;
        for(int k=0;k<4;k++){
            int x=number_tiles[k];
            while(x>0){
                randomno=r.nextInt(tracks-1);
                if (patharray[randomno]==0){
                    patharray[randomno]=k+1;
                    x--;
                }
        }           
        }
        //printing path
        for(int ria=0;ria<tracks;ria++){
            System.out.print(patharray[ria]+" ");
        }
        
       int white=tracks-(number_tiles[0]+number_tiles[1]+number_tiles[2]+number_tiles[3]);
       
        
        System.out.println(">>Setting up the race track...\n" +
                ">>Danger: There are "+number_tiles[0]+" ,"+ number_tiles[1]+" ,"+number_tiles[2]+" numbers of Snakes, Cricket, and Vultures respectively on your track!\n"+
                ">>Danger: Each Snake, Cricket, and Vultures can throw you back by "+score_tiles[0]+" ,"+ score_tiles[1]+" ,"+score_tiles[2]+" number of Tiles respectively! \n"+
                ">>Good News: There are "+ number_tiles[3] +" number of Trampolines on your track!\n" +
                ">>Good News: Each Trampoline can help you advance by "+score_tiles[3]+" number of Tiles");
    
        System.out.println(">>Enter the Player Name");
        String player_name=Sc.next();
        Player newplayer=new Player(player_name);
        
        System.out.println(">>Starting the game with "+Player.player +" at Tile-1\n" +
            ">>Control transferred to Computer for rolling the Dice for "+Player.player+"\n" +
            ">>Hit enter to start the game");
//    try{
        Sc.nextLine();
        Sc.nextLine();
//        String space=Sc.nextLine();
//        if(space.equals(null)){
//            System.out.println("huguig");
//        }
//    }
//    catch(InputMismatchException e){
        System.out.println("Press ENTER");
//        return;
//    }
        System.out.println(">>Game Started ======================>");
        gamestart(patharray,tracks,score_tiles);

    
    
    }
    public static void gamestart(int [] patharray,int tracks,int [] score_tiles){
       ArrayList <Tile> tilepath=new ArrayList<Tile>();
        int a=Die.roll();
       while(a!=6){
           System.out.println(">>[Roll- "+roll_count+ "]: "+ Player.player+" rolled "+ a+" at Tile-1, OOPs you need 6 to start");
           a=Die.roll();
       }
       System.out.println(">>[Roll- "+roll_count+ "]: "+ Player.player +" rolled 6  at Tile-1. You are out of the cage! You get a free roll");
       
       playgame(patharray,tracks,tilepath,score_tiles) ;
       count(tilepath);

    }
    public static void playgame(int [] patharray,int tracks,ArrayList<Tile> tilepath,int [] score_tiles){
//        if(tileno==tracks){
//            throw new WinnerException(player_name+" wins the race at "+roll_count+" rolls");
//            
//            System.out.println(player_name+" wins the race at "+roll_count+" rolls");
//            return;
//        }
        try{
            if(tileno==tracks){
//                System.out.println("yo");
              throw new WinnerException(Player.player+" wins the race at "+roll_count+" rolls");

            }
        }
        catch(WinnerException e){
            System.out.println(e.getMessage());
             return;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index Out Of Bounds Exception of Array");
        }
        catch (NullPointerException e){
            System.out.println("Null Pointer Exception");
        }
        catch(Exception e){
            System.out.println("There is an exception raised");
        }
        int a=Die.roll();
        
        System.out.println(">>[Roll- "+roll_count+ "]: "+ Player.player+" rolled "+ a+" at Tile"+tileno +",landed on Tile-"+(tileno+a)); 
        tileno+=a;
        if(tileno<=0){
            tileno=1;
        }
        else if(tileno>tracks){
            tileno-=a;
        }
        
        Tile obj;
        
        if(patharray[tileno-1]==1){
            //snake
            obj=new Snake();
            
        }
        else if(patharray[tileno-1]==2){
            //vulture
            obj=new Vulture();
        }
        else if(patharray[tileno-1]==3){
             //cricket
             obj=new Cricket();
        }
        else if(patharray[tileno-1]==4){
            //trampoline
            obj=new Trampoline();
        }
        else {
            //white
            obj=new White();
        }
        try{
           obj.shake(obj,score_tiles,tracks); 
        }
        catch(SnakeBiteException e){
            System.out.println("Exception occured "+e.getMessage());
        }
        catch(VultureBiteException e){
            System.out.println("Exception occured "+e.getMessage());
        }
        catch(CricketBiteException e){
            System.out.println("Exception occured "+e.getMessage());
        }
        catch(TrampolineBiteException e){
            System.out.println("Exception occured "+e.getMessage());
        }
        tilepath.add(obj);          //inserting tile object at index tieno-1 
        System.out.println(Player.player+ " moved to  Tile - "+tileno);
        
        playgame(patharray,tracks,tilepath,score_tiles);
    }
   public static void count(ArrayList<Tile> tilepath){
       int snake=0;
       int vulture=0;
       int cricket=0;
       int trampoline=0;

       for(int i=0;i<tilepath.size();i++){
           if(tilepath.get(i) instanceof Snake){
               snake++;
//           System.out.println("found a snake");
            }
           else if(tilepath.get(i) instanceof Vulture){
               vulture++;
//               System.out.println("found a vulture");
           }
           else if(tilepath.get(i) instanceof Cricket){
               cricket++;
//               System.out.println("found a cricket");
           }
           
           else if(tilepath.get(i) instanceof Trampoline){
               trampoline++;
//               System.out.println("found a Trampoline");
           }
       }
       System.out.println("Total snake bites "+snake);
       System.out.println("Total vulture bites "+vulture);
       System.out.println("Total cricket bites "+cricket);
       System.out.println("Total trampoline bites "+trampoline);

   } 
}
class Die{
    
    public static int roll(){
        Random r=new Random();
        int roll=r.nextInt(6)+1;
        Game.roll_count+=1;
        return roll;
    }
}