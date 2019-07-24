/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class Deck extends GroupOfCards<CribbageCard> {

	public Deck() {
		super(52);
		for (Suit suit : Suit.values()){
			for (Value value : Value.values()){
				addCard(new CribbageCard(suit, value));
			}
		}
	}
	
	public void deal(RegularHand dealer, RegularHand nonDealer){
		shuffle();
		for (int i = 0; i < 6; i ++){
			nonDealer.addCard(takeCard());
			dealer.addCard(takeCard());
		}
	}

}
