/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class StandardPlayingCard extends SuitValueCard<Suit, Value> {

	private Suit suit;
	private Value value;
	
	public StandardPlayingCard(Suit suit, Value value){
		this.suit = suit;
		this.value = value;
	}
	
	@Override
	Suit getSuit() {
		return suit;
	}

	@Override
	void setSuit(Suit suit) {
		this.suit = suit;
	}

	@Override
	Value getValue() {
		return value;
	}

	@Override
	void setValue(Value value) {
		this.value = value;
	}

}
