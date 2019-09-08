


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */
class Tile {
    public Tile(){
    
    }
  public void shake(Tile obj,int [] score_tiles,int tracks)throws SnakeBiteException,CricketBiteException,VultureBiteException,TrampolineBiteException{
      System.out.println("Trying to shake the Tile-"+Game.tileno);
      if(obj instanceof Snake){
          Game.tileno-=score_tiles[0];
          throw new SnakeBiteException("Hiss...! I am a Snake, you go back "+ score_tiles[0] +" tiles!");
      }
      else if(obj instanceof Vulture){
           Game.tileno-=score_tiles[2];
        throw new VultureBiteException("Yapping...! I am a Vulture, you go back "+ score_tiles[2] +" tiles!");
    }
    else if(obj instanceof Cricket){
         Game.tileno-=score_tiles[1];
        throw new CricketBiteException("Chirp...! I am a Cricket,you go back "+score_tiles[1] +" tiles!");
        }
    else if(obj instanceof Trampoline){
         Game.tileno+=score_tiles[3];
         if(Game.tileno>tracks){
            Game.tileno-=score_tiles[3];
        }
      throw new TrampolineBiteException("PingPong! I am a Trampoline, you advance "+score_tiles[3] +" tiles!");
    }
    else{
        System.out.println("I am a White tile!");
    }
      if(Game.tileno<=0){
            Game.tileno=1;
        }
//        else if(Game.tileno>tracks){
//            tileno-=a;
//        }
  }
}
class Snake extends Tile{
//    public void shake(int tileno,int [] patharray){
//        try{
//            System.out.println("Hiss...! I am a Snake, you go back "+ patharray[0] +" tiles!");
//            tileno-=patharray[0];
//        }
//        catch(SnakeBiteException se){
//            
//        }
       
        
//       System.out.println(">> Hiss...! I am a Snake, you go back"+  +"tiles!") 
    }

class Vulture extends Tile{
//    @Override
//    public void shake(int tileno){
//        
//       
//    }
}
class Cricket extends Tile{
//    public void shake(){
        
       
//    }
}
class White extends Tile{
//    public void shake(){
        
       
//    }
}
class Trampoline extends Tile{
//    public void shake(){
        
       
//    }
}


class SnakeBiteException extends Exception{
    public SnakeBiteException(String message){
        super(message);
    }
}
class CricketBiteException extends Exception{
    public CricketBiteException(String message){
        super(message);

    }
}
class VultureBiteException extends Exception{
    public VultureBiteException(String message){
        super(message);

    }
}
class TrampolineBiteException extends Exception{
    public TrampolineBiteException(String message){
        super(message);

    }
}   