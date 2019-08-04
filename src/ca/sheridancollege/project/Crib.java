/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class Crib extends Hand {

	@Override
	public int flush(CribbageCard starter){
		for (CribbageCard card : showCards()){
			if (card.getSuit() != starter.getSuit()){
				return 0;
			}
		}
		return 5;
	}

}
