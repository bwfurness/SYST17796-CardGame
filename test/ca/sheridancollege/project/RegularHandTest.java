/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author h
 */
public class RegularHandTest {
	
	public RegularHandTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of flush method, of class RegularHand.
	 */
	@Test
	public void testFlushZero() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.SPADE, Value.ACE);
		RegularHand instance = new RegularHand();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.TWO));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.THREE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FOUR));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FIVE));
		int expResult = 0;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of flush method, of class RegularHand.
	 */
	@Test
	public void testFlushFour() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.CLUB, Value.ACE);
		RegularHand instance = new RegularHand();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.TWO));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.THREE));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FOUR));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FIVE));
		int expResult = 4;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of flush method, of class RegularHand.
	 */
	@Test
	public void testFlushFive() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.SPADE, Value.ACE);
		RegularHand instance = new RegularHand();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.TWO));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.THREE));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FOUR));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FIVE));
		int expResult = 5;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}

}
