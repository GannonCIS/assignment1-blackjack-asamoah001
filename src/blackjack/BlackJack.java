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
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dealer fred =new Dealer(2);
        fred.playGame();
        
       /* Deck myDeck = new Deck();
        Hand myHand = new  Hand();
        for(int i=0; i < 6; i++){
            myHand.addCard(myDeck.dealCard());
            System.out.println("numOfCards:"+ myHand.getNumOfCards()+""+"score"+myHand.getScore());*/
        }
       /** myDeck.printDeck();
       
       for(int i = 0; i < 54; i++){
           Card temp = myDeck.dealCard();
           System.out.println(temp.RANK + "-of-" + temp.SUIT);
       }*/
    }
    

