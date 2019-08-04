/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Hand extends GroupOfCards<CribbageCard> {

	public Hand() {
		super(6);
	}
	
	
	public int countPoints(Starter starter){
		int points = 0;
		CribbageCard starterCard = starter.showCards().get(0);
		System.out.println ("\n\n");
		System.out.println (starterCard);
		for (CribbageCard card : showCards()){
			System.out.println(card);
			if (card.getValue() == Value.JACK){
				if (card.getSuit() == starterCard.getSuit()){
					System.out.println("One for the Jack");
					points = 1;
					//break;
				}
			}
		}
		ArrayList<CribbageCard> handPlusStarter = new ArrayList<>(5);
		handPlusStarter.addAll(showCards());
		handPlusStarter.add(starterCard);
		points += count15(handPlusStarter);
		System.out.println("15 " + points);
		points += pair(handPlusStarter);
		System.out.println("Pair is " + points);
		points += run(handPlusStarter);
		System.out.println("Run is " + points);
		points += flush(starterCard);
		System.out.println("Flush for " + points);
		return points;
	}
	
	// silently counts points with no starter.
	public int countPoints(){
		int points = 0;
		ArrayList<CribbageCard> handPlusStarter = new ArrayList<>(5);
		handPlusStarter.addAll(showCards());
		points += count15(handPlusStarter);
		points += pair(handPlusStarter);
		points += run(handPlusStarter);
		points += flush(null);
		return points;	
	}
	
	public void removeCardAt(int index){
		showCards().remove(index);
	}
	
	public int count15(List<CribbageCard> cards){
		return count15(0, cards);
	}
	
	public int count15(int total, List<CribbageCard> cards){
		int ret = 0;
		for (int i = 0; i < cards.size(); i++){
			int newTotal = total + cards.get(i).getPoints();
			if (newTotal < 15){
				if (i < cards.size() - 1){
					ret += count15(newTotal, cards.subList(i + 1, cards.size()));
				}
			}else if (newTotal == 15){
				ret += 2;
			}
		}
		return ret;
	}
	
	public int pair(List<CribbageCard> cards){
		int ret = 0;
		for (int i = 1; i < cards.size(); i++){
			for (int j = 0; j < i; j++){
				if (cards.get(i).getValue() == cards.get(j).getValue()){
					ret += 2;
				}
			}
		}
		return ret;
	}
	
	public int run(List<CribbageCard> cards){
		int ret = 0;
		ArrayList<CribbageCard> lowCards = new ArrayList<>(5);
		for (int i = 0; i < cards.size(); i++){
			for (int j = 0; j < cards.size(); j++){
				if (cards.get(i).getValue().compareTo(cards.get(j).getValue()) == 1){
					break;
				}else if (j == cards.size() - 1){ // on the last iteration.
					lowCards.add(cards.get(i));
				}
			}
		}
		// okay now that we have the lowCards, we can attempt to find runs starting from them.
		for (CribbageCard lowCard : lowCards){
			ret += run(lowCard, cards, 1);
		}
		return ret;
	}
	
	public int run(CribbageCard lowCard, List<CribbageCard> cards, int depth){
		int ret = 0;
		for (CribbageCard card : cards){
			if (lowCard.getValue().compareTo(card.getValue()) == -1){
				if (depth == 2){
					ret += 3;
				}else if (depth >= 3){
					ret += 1;
				}
				ret += run(card, cards, depth + 1);
			}
		}
		return ret;
	}
	
	
	public abstract int flush(CribbageCard starter);
	

}
