/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
import java.util.Scanner;

public class Dealer {
    
    private  Hand dealerHand = new Hand();
    private  Player[] myPlayers = new Player[0];
    private  Deck myDeck = new Deck();
    private Scanner scan = new Scanner(System.in);
    
    public Dealer(){
         System.out.println("How many players?");
         int num = scan.nextInt();
         initPlayers(num);
     }

      Dealer(int numOfPlayers){
         initPlayers(numOfPlayers);
     }

     
    public void dealOpeningHand(){
        for (int i = 0; i < 2; i++){
             for (Player currPlayer : myPlayers){
                 currPlayer.getMyHand().addCard(myDeck.dealCard());
             }
             dealerHand.addCard(myDeck.dealCard());
         } 
       
    }
    
    public void  playOutPlayerHand(){
           for (Player currPlayer : myPlayers){
             System.out.println("\n" + currPlayer.getName() + "'s Hand");
             currPlayer.getMyHand().printHand();
             while (currPlayer.getMyHand().getNumOfCards() < 5 && 
                     currPlayer.getMyHand().getScore() < 21){
                 System.out.println("Want a hit? (y/n)");
                 char opt = scan.next().toLowerCase().charAt(0);
                 System.out.print("\n");
                 if (opt == 'y'){
                     currPlayer.getMyHand().addCard(myDeck.dealCard());
                 }else{
                     break;
                 }
                 currPlayer.getMyHand().printHand();
             }
         }
    }  
    public void playOutDealerHand(){

         while (dealerHand.getScore() < 16 && dealerHand.getNumOfCards() < 5){
             dealerHand.addCard(myDeck.dealCard());
         }
         System.out.println("Dealer's Hand: ");
         dealerHand.printHand();
     }
    
    public void declareWinners(){
        if(dealerHand.getScore() > 21){
             System.out.println("The dealer loses, everyone else wins!");
         }else{
             for (Player currPlayer : myPlayers){
                 if(currPlayer.getMyHand().getNumOfCards() > 5 || 
                         currPlayer.getMyHand().getScore() > 21 || 
                         (currPlayer.getMyHand().getNumOfCards() > 5 &&
                         currPlayer.getMyHand().getScore() > 21)){
                     System.out.println(currPlayer.getName() + " busted!");
                 }else{
                     if(currPlayer.getMyHand().getScore() == 21){
                         if (dealerHand.getScore() == 21){
                             System.out.println("The dealer defeats " + 
                                     currPlayer.getName() + 
                                     " with a score of 21!");
                         }else{
                             System.out.println(currPlayer.getName() + 
                                     " defeats the dealer with a score of 21!");
                         }
                     }else if(currPlayer.getMyHand().getScore() > 
                             dealerHand.getScore()){
                         System.out.println(currPlayer.getName() + 
                                 " defeats the dealer with a score of " + 
                                 currPlayer.getMyHand().getScore());
                     }else{
                         System.out.println("The dealer defeats " + 
                                     currPlayer.getName() + 
                                     " with a score of " + 
                                 dealerHand.getScore());
                     }
                 }
             }
         }

     }    
    private void initPlayers(int numOfPlayers){
         myPlayers = new Player[numOfPlayers];
         for(int i = 0; i < myPlayers.length; i++){
             System.out.println("Player " + (i+1) + ", what's your name?");
             String name = scan.next();
             if(name.equals("")){
                 myPlayers[i] = new Player(i+1);
             }else{
                 myPlayers[i] = new Player(name);
             }
         }
     }
    
}
    /*public Dealer(int numOfPlayers){
            initMyPlayers(numOfPlayers);
    }
        public void dealOutOpeningHand(){
            for(int i = 0; i<2; i++) {
                for(Player curryPlayer : myPlayers){
                    curryPlayer.getClass().addCard(myDeck.dealCard());
                }
                dealerHand.addCard(myDeck.dealCard());
            }
        }
        
        public void takePlayerTurns(){
            for(Player currplayer : myPlayers){
                while(currplayer.getMyHand().getStore() <21){
                    System.out.println(currPlayer.getName() +"'s Hand");
                    curryPlayer.getMyHand().printHand();
                    System.out.println("Wanna hit? (y/n");
                    char opt =scan.next().charAt(0);
                    if (opt=='y'){
                        currPlayer.getMyHand().addCard(myDeck.dealCard());
                     }
                    }
                    currPlayer.getMyHand().printHand();
                }
            }
        
        
        
        public void playerOutDealHand(){
        
        }
        
        public void declareWinners(){
        
        }
    
       private void initMyPlayers(int num) {     
        myPlayers = new Player[numOfPlayers];
        for(int i = 0;i < myPlayers.length; i++){
            System.out.println("Player"+ (1+1 +"what's your name: "));
            String name = scan.next();
            if(name.equals("")){
                myPlayers[i] =new Player(1+1);
            }else{
                myPlayers[i] = new Player(name);
            }
            
        }
    }
         public Card declareWinners(){
            return null;  
        
        } 
    
    
    }*/