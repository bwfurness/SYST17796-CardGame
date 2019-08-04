/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class Starter extends GroupOfCards<CribbageCard> {
	
	public Starter() {
		super(1);
	}
	
	@Override
	public int addCard(CribbageCard card){
		super.addCard(card);
		System.out.println ("The Starter is a " + card.toString());
		if (card.getValue() == Value.JACK){
			return 2;
		}else{
			return 0;
		}
	}
	
}
