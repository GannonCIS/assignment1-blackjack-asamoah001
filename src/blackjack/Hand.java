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
public class Hand {
   private final  Card[]  myCards = new Card[5];
   private  int numOfCards = 0;
   private  int score = 0 ;
   
   public Hand(){}
   public int getNumofCards(){
       return numOfCards;
   }
   
   public int getscore(){
       return score;
   } 
   
   public void addCard(Card  newCard){
    if (numOfCards > 4){
        System.out.println("Too many cards for this hand");
   }else{
            myCards[numOfCards] = newCard;
            numOfCards++;
            try{
            score += Integer.parseInt(newCard.RANK);
            } catch (java.lang.NumberFormatException ex){
                if(newCard.RANK.equals("Ace")){
                    score += 1;
                } else {
                    score += 10;
                }
            }
        }
    }
   
   public void printHand (){
       for (Card myCard : myCards) {
           System.out.println(myCard.RANK + "of" + myCard.SUIT);
       }
                
        
            }

    int getStore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
   }
    

