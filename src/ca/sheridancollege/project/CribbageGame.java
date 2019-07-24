/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 */
public class CribbageGame extends Game<CribbagePlayer> {

	private Deck deck;
	private AIPlayer aiPlayer;
	private HumanPlayer humanPlayer;
	private Starter starter;
	private Pegging pegging;
	private boolean humanCrib;
	
	
	public CribbageGame() {
		super("Cribbage");
		deck = new Deck();
		aiPlayer = new AIPlayer("AI"); // TODO: figure out if this name is useful.
		humanPlayer = new HumanPlayer("Human");
		starter = new Starter();
		pegging = new Pegging();
		// todo - cut the deck twice to determine who gets first crib.
		humanCrib = true;
	}
	

	@Override
	public void play() {
		CribbagePlayer playerWithCrib, playerWithoutCrib;
		if (humanCrib){
			playerWithCrib = humanPlayer;
			playerWithoutCrib = aiPlayer;
		}else{
			playerWithCrib = aiPlayer;
			playerWithoutCrib = humanPlayer;
		}
		RegularHand cribHand = playerWithCrib.getHand();
		RegularHand nonCribHand = playerWithCrib.getHand();
		deck.deal(cribHand, nonCribHand);
		playerWithoutCrib.play();
		playerWithCrib.play();
		playerWithCrib.score(starter.addCard(deck.takeCard()));
	}

	@Override
	public void declareWinner() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
