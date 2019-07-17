/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 * @param <SUIT>
 * @param <VALUE>
 */
public abstract class SuitValueCard<SUIT extends Enum, VALUE extends Enum> extends Card {
	
	abstract SUIT getSuit();
	
	abstract void setSuit(SUIT suit);
	
	abstract VALUE getValue();
	
	abstract void setValue(VALUE value);

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
 
}
