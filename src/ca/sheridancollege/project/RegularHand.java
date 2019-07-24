/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

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

}
