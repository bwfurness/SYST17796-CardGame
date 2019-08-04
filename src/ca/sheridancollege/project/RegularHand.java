/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.List;

/**
 *
 */
public class RegularHand extends Hand {
	
	public void giveToCrib(CribbageCard card, Crib crib){
		if (removeCard(card)){
			crib.addCard(card);
		}else{
			throw new IllegalArgumentException(card.toString() + " is not in this hand.");
		}
	}

	public RegularHand copy(){
		RegularHand copy = new RegularHand();
		for (CribbageCard card : showCards()){
			addCard(card);
		}
		return copy;
	}
	
	@Override
	public int flush(CribbageCard starter){
		List<CribbageCard> hand = showCards();
		// yes, 1
		for (int i = 1; i < hand.size(); i++){
			if (hand.get(0).getSuit() != hand.get(i).getSuit()){
				return 0;
			}
		}
		if (starter != null && hand.get(0).getSuit() == starter.getSuit()){
			return 5;
		}else{
			return 4;
		}
	}

	
}
