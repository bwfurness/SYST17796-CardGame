/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 */
public class HumanPlayer extends CribbagePlayer {

	Scanner scanner = new Scanner (System.in);
	
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
		int code = scanner.nextInt() - 1;
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
		int code = scanner.nextInt() - 1;
		hand.giveToCrib(hand.showCards().get(code), getCrib());
		i = 1;
		for (CribbageCard card : hand.showCards()){
			System.out.println (i + ") " + card.toString());
			i++;
		}
		code = scanner.nextInt() - 1;
		hand.giveToCrib(hand.showCards().get(code), getCrib());
	}

}
