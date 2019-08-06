/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public abstract class CribbagePlayer extends Player {

	private RegularHand hand;
	private Crib crib;
	private int points;
	private CribbagePhase phase;
	protected final Pegging pegging;
	private CribbageCard[] placedCards = new CribbageCard[4];
	
	public CribbagePlayer(String name, Pegging pegging) {
		super(name);
		hand = new RegularHand();
		points = 0;
		phase = CribbagePhase.PREPLAY;
		this.pegging = pegging;
	}
	
	public void setCrib(Crib crib){
		this.crib = crib;
	}

	@Override
	public boolean play() {
		switch (phase){
			case PREPLAY:
				preplay();
				phase = CribbagePhase.PEG;
				unplace();
				break;
			case PEG:
				return peg();
		}
		return false;
	}
	
	public abstract void preplay();

	
	public abstract boolean peg();
	
	public Crib getCrib(){
		return crib;
	}
	
	public enum CribbagePhase{
		PREPLAY,
		PEG
	}
	
	public boolean place(int code){
		int i = 0;
		for (CribbageCard card : hand.showCards()){
			if (pegging.canPlay(card) && !placed(card)){
				if (i == code){
					score(pegging.addCard(card));
					for (int j = 0; j < 4; j++){
						if (placedCards[j] == null){
							placedCards[j] = card;
							return true;
						}
					}
				}
				i ++;
			}
		}
		return false;
	}
	
	public void newTurn(){
		phase = CribbagePhase.PREPLAY;
	}
	
	public void unplace(){
		for (int i = 0; i < 4; i++){
			placedCards[i] = null;
		}
	}
	
	public boolean placed(CribbageCard card){
		for (int i = 0; i < 4; i++){
			if (placedCards[i] == card){ // yes, == will work here.
				return true;
			}
		}
		return false;
	}
	
	public RegularHand getHand(){
		return hand;
	}
	
	public boolean score(int points){
		this.points += points;
		return this.points > 120;
	}
	
	public int getPoints(){
		return points;
	}
	
	public boolean won(){
		return points > 120;
	}
	
	
	public boolean skunked(){
		return points <= 90;
	}
	
}
