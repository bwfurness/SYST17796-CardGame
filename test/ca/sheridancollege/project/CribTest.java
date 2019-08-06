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
public class CribTest {
	
	public CribTest() {
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
	 * Test of flush method, of class Crib.
	 */
	@Test
	public void testFlushGood() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.CLUB, Value.FIVE);
		Crib instance = new Crib();
		instance.addCard(new CribbageCard(Suit.CLUB, Value.ACE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.TWO));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.THREE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FOUR));
		int expResult = 5;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}

	/**
	 * Test of flush method, of class Crib.
	 */
	@Test
	public void testFlushBad() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.CLUB, Value.FIVE);
		Crib instance = new Crib();
		instance.addCard(new CribbageCard(Suit.HEART, Value.ACE));
		instance.addCard(new CribbageCard(Suit.DIAMOND, Value.TWO));
		instance.addCard(new CribbageCard(Suit.SPADE, Value.THREE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FOUR));
		int expResult = 0;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}

	/**
	 * Test of flush method, of class Crib.
	 */
	@Test
	public void testFlushBoundary() {
		System.out.println("flush");
		CribbageCard starter = new CribbageCard(Suit.SPADE, Value.FIVE);
		Crib instance = new Crib();
		instance.addCard(new CribbageCard(Suit.CLUB, Value.ACE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.TWO));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.THREE));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FOUR));
		int expResult = 0;
		int result = instance.flush(starter);
		assertEquals(expResult, result);
	}
	
}
