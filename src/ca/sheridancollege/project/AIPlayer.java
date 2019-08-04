/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class AIPlayer extends CribbagePlayer {

	public AIPlayer(String name, Pegging pegging) {
		super(name, pegging);
	}

	
	@Override
	public void preplay(){
		// we will make the ai make sense later
		getHand().giveToCrib(getHand().showCards().get(0), getCrib());
		getHand().giveToCrib(getHand().showCards().get(0), getCrib());
	}
	
	@Override
	public boolean peg(){
		RegularHand hand = getHand();
		for (CribbageCard card : hand.showCards()){
			if (pegging.canPlay(card) && !placed(card)){
				System.out.println("The AI played " + card.toString());
				break;
			}
		}
		return place(0);
	}
}
