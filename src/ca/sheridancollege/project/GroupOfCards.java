/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @param <T> Card type
 */
public class GroupOfCards <T extends Card> {
   
    //The group of cards, stored in an ArrayList
    private ArrayList <T> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize) {
        size = givenSize;
		cards = new ArrayList<>(size);
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of	 cards.
     */
    public ArrayList<T> showCards() {
        return cards;
    }
    
    public void shuffle() {
		Collections.shuffle(cards);
    }
	
	public int addCard(T card) {
		cards.add(card);
		return 0;
	}
	
	public T takeCard(){
		return cards.remove(0);
	}
	
	public boolean removeCard(T card){
		return cards.remove(card);
	}
	
    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
