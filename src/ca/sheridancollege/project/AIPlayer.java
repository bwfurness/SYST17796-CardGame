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
		// the AI currently does not consider the crib.
		int card1 = 0;
		int card2 = 0;
		int score = -1;
		for (int i = 0; i < 5; i ++){
			for (int j = i + 1; j < 6; j ++){
				Hand tempHand = getHand().copy();
				tempHand.removeCardAt(j);
				tempHand.removeCardAt(i);
				if (tempHand.countPoints() > score){
					card1 = i;
					card2 = j;
					score = tempHand.countPoints();
				}
			}
		}
		// we will make the ai make sense later
		getHand().giveToCrib(getHand().showCards().get(card2), getCrib());
		getHand().giveToCrib(getHand().showCards().get(card1), getCrib());
		getHand().showCards().sort((a, b) -> {return b.getValue().compareTo(a.getValue());});
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
		if (place(0)){
			return true;
		}else{
			System.out.println("The AI calls go");
			return false;
		}
	}
}
