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
    static ArrayList <Tile> path=new ArrayList<Tile>();
    public static void main(String [] args){
        
        Scanner Sc=new Scanner(System.in);
        System.out.print(">>Enter total number of tiles on the race track (length)\n" );
        int tracks=Sc.nextInt();
        int [] number_tiles=new int[4];
        int [] score_tiles=new int[4];
        Random r=new Random();
        for(int i=0;i<4;i++){
            number_tiles[i]=r.nextInt(tracks/4)+1;
        }
        for(int i=0;i<4;i++){
            score_tiles[i]=r.nextInt(10)+1;
        }
        
        
        System.out.println(">>Setting up the race track...\n" +
                ">>Danger: There are "+number_tiles[0]+" ,"+ number_tiles[1]+" ,"+number_tiles[2]+" numbers of Snakes, Cricket, and Vultures respectively on your track!\n"+
                ">>Danger: Each Snake, Cricket, and Vultures can throw you back by "+score_tiles[0]+" ,"+ score_tiles[1]+" ,"+score_tiles[2]+" number of Tiles respectively! \n"+
                ">>Good News: There are "+ number_tiles[3] +" number of Trampolines on your track!\n" +
                ">>Good News: Each Trampoline can help you advance by "+score_tiles[3]+" number of Tiles");
    
        System.out.println(">>Enter the Player Name");
        String player_name=Sc.next();
        System.out.println(">>Starting the game with "+player_name +" at Tile-1\n" +
            ">>Control transferred to Computer for rolling the Dice for "+player_name+"\n" +
            ">>Hit enter to start the game");
    
        Sc.nextLine();
        Sc.nextLine();
        System.out.println(">>Game Started ======================>");
        gamestart(player_name);

    
    
    }
    public static void gamestart(String player_name){
       int a=Die.roll();
       while(a!=6){
           System.out.println(">>[Roll- "+roll_count+ "]: "+ player_name+" rolled "+ a+" at Tile-1, OOPs you need 6 to start");
           a=Die.roll();
       }
       System.out.println(">>[Roll- "+roll_count+ "]: "+ player_name +" rolled 6  at Tile-1. You are out of the cage! You get a free roll");
       
       playgame(player_name);

    }
    public static void playgame(String player_name){
        
        int a=Die.roll();
        System.out.println(">>[Roll- "+roll_count+ "]: "+ player_name+" rolled "+ a+" at Tile-1,landed on Tile-");   

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