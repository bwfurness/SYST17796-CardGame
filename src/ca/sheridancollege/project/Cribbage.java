/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class Cribbage {
	
	public static void main (String[] args){
		CribbageGame game = new CribbageGame();
		do {
			game.play();
		} while (!game.won());
		game.declareWinner();
	}

}
