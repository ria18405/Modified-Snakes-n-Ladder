/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RiaGupta
 */
public class Exception {
    
//    public Exception(int [] score tile){
//        
//    }
}
class SnakeBiteException extends Exception{
    public SnakeBiteException(int [] score_tiles){
        
        System.out.println(">> Hiss...! I am a Snake, you go back "+ score_tiles[0] +"tiles!");

    }
}
class CricketBiteException extends Exception{
    public CricketBiteException(){
//       System.out.println(">> Chirp...! I am a Cricket, you go back "+score_tile[1] +" tiles!");

    }
}
class VultureBiteException extends Exception{
    
}
class TrampolineException extends Exception{
    
}   