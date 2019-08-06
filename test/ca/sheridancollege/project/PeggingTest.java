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
public class PeggingTest {
	
	public PeggingTest() {
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
	 * Test of canPlay method, of class Pegging.
	 */
	@Test
	public void testCanPlayGood() {
		System.out.println("canPlay");
		CribbageCard card = new CribbageCard(Suit.CLUB, Value.KING);
		Pegging instance = new Pegging();
		boolean expResult = true;
		boolean result = instance.canPlay(card);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of canPlay method, of class Pegging.
	 */
	@Test
	public void testCanPlayBad() {
		System.out.println("canPlay");
		CribbageCard card = new CribbageCard(Suit.CLUB, Value.KING);
		Pegging instance = new Pegging();
		instance.addCard(card);
		card = new CribbageCard(Suit.SPADE, Value.TEN);
		instance.addCard(card);
		card = new CribbageCard(Suit.DIAMOND, Value.JACK);
		instance.addCard(card); // current total is 30.
		card = new CribbageCard(Suit.HEART, Value.QUEEN);
		boolean expResult = false;
		boolean result = instance.canPlay(card);
		assertEquals(expResult, result);
	}
	

	/**
	 * Test of canPlay method, of class Pegging.
	 */
	@Test
	public void testCanPlayBoundary() {
		System.out.println("canPlay");
		CribbageCard card = new CribbageCard(Suit.CLUB, Value.KING);
		Pegging instance = new Pegging();
		instance.addCard(card);
		card = new CribbageCard(Suit.SPADE, Value.TEN);
		instance.addCard(card);
		card = new CribbageCard(Suit.DIAMOND, Value.JACK);
		instance.addCard(card); // current total is 30.
		card = new CribbageCard(Suit.HEART, Value.TWO);
		boolean expResult = false;
		boolean result = instance.canPlay(card); // cannot play a total of 32
		assertEquals(expResult, result);
		card = new CribbageCard(Suit.HEART, Value.ACE);
		result = instance.canPlay(card); // can play a total of 31
		expResult = true;
		assertEquals(expResult, result);
	}
	
}
