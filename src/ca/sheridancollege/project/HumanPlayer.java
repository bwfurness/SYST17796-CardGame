/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class HumanPlayer extends CribbagePlayer {

	IntReader reader = new IntReader ();
	
	public HumanPlayer(String name, Pegging pegging) {
		super(name, pegging);
		
	}
	
	@Override
	public boolean peg(){
		System.out.println ("The current total is " + pegging.getCurrentCount());
		RegularHand hand = getHand();
		int i = 1;
		for (CribbageCard card : hand.showCards()){
			if (pegging.canPlay(card) && !placed(card)){
				System.out.println(i + ") " + card.toString());
				i ++;
			}
		}
		if (i == 1){
			return false;
		}
		int code = reader.nextInt(1, i) - 1;
		place(code);
		return true;
	}
	
	@Override
	public void preplay(){
		RegularHand hand = getHand();
		int i = 1;
		for (CribbageCard card : hand.showCards()){
			System.out.println (i + ") " + card.toString());
			i ++;
		}
		int code = reader.nextInt(1, i) - 1;
		hand.giveToCrib(hand.showCards().get(code), getCrib());
		i = 1;
		for (CribbageCard card : hand.showCards()){
			System.out.println (i + ") " + card.toString());
			i++;
		}
		code = reader.nextInt(1, i) - 1;
		hand.giveToCrib(hand.showCards().get(code), getCrib());
	}

}
