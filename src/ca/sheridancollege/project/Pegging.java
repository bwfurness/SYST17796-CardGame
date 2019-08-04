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
public class Pegging extends GroupOfCards<CribbageCard> {
	
	private int currentCount;
	
	public Pegging() {
		super(8);
		currentCount = 0;
	}
	
	@Override
	public int addCard(CribbageCard card){
		super.addCard(card);
		currentCount += card.getPoints();
		int totalRet = 0; 
		if (currentCount == 15){
			totalRet += 2;
		}
		if (currentCount == 31){
			totalRet += 2;
			currentCount = 0;
		}
		ArrayList<CribbageCard> cards = showCards();
		int pair = 0;
		int scoreCheck = currentCount;
		for (int i = cards.size() - 1; i >= 0; i--){
			scoreCheck -= cards.get(i).getPoints();
			if (scoreCheck < 0){
				break;
			}else if (cards.get(i).getValue() == card.getValue()){
				pair ++;
			}else{
				break;
			}
		}
		switch (pair) {
			case 2:
				totalRet += 2;
				break;
			case 3:
				totalRet += 6;
				break;
			case 4:
				totalRet += 12;
				break;
			default:
				break;
		}
		// okay now to do battle with runs.
		scoreCheck = currentCount;
		int runSize = 0;
		for (int i = cards.size() - 1; i >= 0; i--){
			scoreCheck -= cards.get(i).getPoints();
			if (scoreCheck >= 0){
				if (checkRun (((ArrayList<CribbageCard>)cards.clone()).subList(i, cards.size()))){
					runSize = cards.size() - i;
				}
			}else{
				break;
			}
		}
		if (runSize > 2){
			totalRet += runSize;
		}
		return totalRet;
	}
	
	// checks if they all form a run.
	private boolean checkRun(List<CribbageCard> cards){
		cards.sort((a, b) -> {return a.getValue().compareTo(b.getValue());});
		for (int i = 1; i < cards.size(); i ++){
			if (cards.get(i - 1).getValue().compareTo(cards.get(i).getValue()) != -1){
				System.out.println(cards.get(i - 1).getValue().compareTo(cards.get(i).getValue()));
				return false;
			}
		}
		return true;
	}
	
	public boolean canPlay(CribbageCard card){
		return currentCount + card.getPoints() <= 31;
	}
	
	public boolean isFull(){
		return showCards().size() == getSize();
	}
	
	public void refresh(){
		currentCount = 0;
	}
	
	public int getCurrentCount(){
		return currentCount;
	}
	
}
