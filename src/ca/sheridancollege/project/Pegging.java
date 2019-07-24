/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class Pegging extends GroupOfCards<CribbageCard> {
	
	public int currentCount;
	
	public Pegging() {
		super(8);
		currentCount = 0;
	}
	
	@Override
	public int addCard(CribbageCard card){
		super.addCard(card);
		currentCount += card.getPoints();
		return 0;
	}
	
	public boolean canPlay(CribbageCard card){
		return currentCount + card.getPoints() <= 31;
	}
	
}
