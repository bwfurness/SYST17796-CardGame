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

	public CribbagePlayer(String name) {
		super(name);
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
	
}
