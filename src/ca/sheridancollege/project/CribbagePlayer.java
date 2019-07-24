/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class CribbagePlayer extends Player {

	private RegularHand hand;
	private int points;
	private CribbagePhase phase;
	
	public CribbagePlayer(String name) {
		super(name);
		hand = new RegularHand();
		points = 0;
	}

	@Override
	public void play() {
		switch (phase){
			case PREPLAY:
				preplay();
				break;
			case PEG:
				peg();
				break;
			case COUNT:
				count();
				break;
		}
	}
	
	public void preplay(){
		phase = CribbagePhase.PEG;
	}
	
	public void peg(){
	}
	
	public void count(){
		phase = CribbagePhase.PREPLAY;
	}
	
	public void donePegging(){
		phase = CribbagePhase.COUNT;
	}
	
	public enum CribbagePhase{
		PREPLAY,
		PEG,
		COUNT
	}
	
	public RegularHand getHand(){
		return hand;
	}
	
	public boolean score(int points){
		this.points += points;
		return points > 120;
	}
	
	public int getPoints(){
		return points;
	}
	
}
