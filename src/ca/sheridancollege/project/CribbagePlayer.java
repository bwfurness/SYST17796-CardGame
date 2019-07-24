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
	
	public CribbagePlayer(String name) {
		super(name);
		hand = new RegularHand();
		points = 0;
	}

	@Override
	public void play() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public enum CribbagePhase{
		preplay,
		peg,
		count
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
