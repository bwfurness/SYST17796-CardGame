/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class CribbageGame extends Game<CribbagePlayer> {

	private final Scanner scanner = new Scanner (System.in);
	
	private final Deck deck;
	private final AIPlayer aiPlayer;
	private final HumanPlayer humanPlayer;
	private final Starter starter;
	private final Pegging pegging;
	private boolean humanCrib;
	private Go go;
	
	public CribbageGame() {
		super("Cribbage");
		deck = new Deck();
		starter = new Starter();
		pegging = new Pegging();
		aiPlayer = new AIPlayer("AI", pegging); // TODO: figure out if this name is useful.
		humanPlayer = new HumanPlayer("Human", pegging);
		// add the players to the list that we never use
		// todo - cut the deck twice to determine who gets first crib.
		humanCrib = Math.random() > 0.5;
	}
	
	@Override
	public ArrayList<CribbagePlayer> getPlayers(){
		System.err.println("Cribbage Players should not be modified directly.");
		return null;
	}
	
	@Override
	public void setPlayers(ArrayList<CribbagePlayer> playersList){
		System.err.println("Cribbage players should not be modified directly.");
	} 
	

	@Override
	public void play() {
		CribbagePlayer playerWithCrib, playerWithoutCrib;
		if (humanCrib){
			System.out.println ("You have Crib");
			playerWithCrib = humanPlayer;
			playerWithoutCrib = aiPlayer;
		}else{
			System.out.println ("The AI has crib");
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
			pegging.clear();
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
				if (playerWithoutCrib.won()){
					return;
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
				if (playerWithCrib.won()){
					return;
				}
			} while (!pegging.isFull());
			if (go == Go.NO_CRIB){
				if (playerWithoutCrib.score(1)){
					return;
				}
			}else if (go == Go.NO_CRIB || pegging.getCurrentCount() > 0){
				if (playerWithCrib.score(1)){
					return;
				}
			}
			if (playerWithoutCrib.score(nonCribHand.countPoints(starter))){
				return;
			}
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
			scanner.nextLine();
			if (playerWithCrib.score(cribHand.countPoints(starter))){
				return;
			}
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
			scanner.nextLine();
			playerWithCrib.score(playerWithCrib.getCrib().countPoints(starter));
			System.out.println("Score:");
			System.out.println("You: " + humanPlayer.getPoints() + "    AI: " + aiPlayer.getPoints());
			scanner.nextLine();
		}
		for (int i = 0; i < 4; i ++){
			deck.addCard(cribHand.takeCard());
			deck.addCard(nonCribHand.takeCard());
			deck.addCard(crib.takeCard());
		}
		deck.addCard(starter.takeCard());
		humanCrib = !humanCrib;
		humanPlayer.newTurn();
		aiPlayer.newTurn();
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
