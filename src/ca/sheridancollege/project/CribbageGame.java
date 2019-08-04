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
	private Go go;
	
	public CribbageGame() {
		super("Cribbage");
		deck = new Deck();
		pegging = new Pegging();
		starter = new Starter();
		aiPlayer = new AIPlayer("AI", pegging); // TODO: figure out if this name is useful.
		humanPlayer = new HumanPlayer("Human", pegging);
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
		RegularHand nonCribHand = playerWithoutCrib.getHand();
		Crib crib = new Crib();
		humanPlayer.setCrib(crib);
		aiPlayer.setCrib(crib);
		deck.deal(cribHand, nonCribHand);
		System.out.println("Score:");
		System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
		playerWithoutCrib.play();
		playerWithCrib.play();
		boolean won = playerWithCrib.score(starter.addCard(deck.cut()));
		if (won){
			return;
		}else{
			go = null;
			do{		
				System.out.println("Score:");
				System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
				if (!playerWithoutCrib.play()){
					if (go == null){
						go = Go.NO_CRIB;
					}else if (go == Go.CRIB){
						playerWithoutCrib.score(1);
						pegging.refresh();
						go = null;
					}
				}
				System.out.println("Score:");
				System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
				if (!playerWithCrib.play()){
					if (go == null){
						go = Go.CRIB;
					}else if (go == Go.NO_CRIB){
						playerWithCrib.score(1);
						pegging.refresh();
						go = null;
					}
				}
			} while (!pegging.isFull());
			if (playerWithoutCrib.score(nonCribHand.countPoints(starter))){
				return;
			}
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
			if (playerWithCrib.score(cribHand.countPoints(starter))){
				return;
			}
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
			playerWithCrib.score(playerWithCrib.getCrib().countPoints(starter));
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
		}
		for (int i = 0; i < 4; i ++){
			deck.addCard(cribHand.takeCard());
			deck.addCard(nonCribHand.takeCard());
			deck.addCard(crib.takeCard());
		}
		deck.addCard(starter.takeCard());
		humanCrib = !humanCrib;
	}

	public boolean won(){
		return aiPlayer.won() || humanPlayer.won();
	}	
	
	
	@Override
	public void declareWinner() {
		if (humanPlayer.won()){
			if (aiPlayer.skunked()){
				System.out.println ("You skunked the AI!");
			}else{
				System.out.println ("You won!");
			}
		}else if (humanPlayer.skunked()){
			System.out.println("You got skunked!");
		}else{
			System.out.println("You lost!");
		}
	}

	enum Go{
		CRIB,
		NO_CRIB;
	}
	
}
