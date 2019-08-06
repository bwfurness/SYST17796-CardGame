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
public class CribbageCardTest {
	
	public CribbageCardTest() {
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
	 * Test of getPoints method, of class CribbageCard.
	 */
	@Test
	public void testGetPoints() {
		System.out.println("getPoints");
		assertEquals(1, new CribbageCard(Suit.CLUB, Value.ACE).getPoints());
		assertEquals(2, new CribbageCard(Suit.CLUB, Value.TWO).getPoints());
		assertEquals(3, new CribbageCard(Suit.CLUB, Value.THREE).getPoints());
		assertEquals(4, new CribbageCard(Suit.CLUB, Value.FOUR).getPoints());
		assertEquals(5, new CribbageCard(Suit.CLUB, Value.FIVE).getPoints());
		assertEquals(6, new CribbageCard(Suit.CLUB, Value.SIX).getPoints());
		assertEquals(7, new CribbageCard(Suit.CLUB, Value.SEVEN).getPoints());
		assertEquals(8, new CribbageCard(Suit.CLUB, Value.EIGHT).getPoints());
		assertEquals(9, new CribbageCard(Suit.CLUB, Value.NINE).getPoints());
		assertEquals(10, new CribbageCard(Suit.CLUB, Value.TEN).getPoints());
		assertEquals(10, new CribbageCard(Suit.CLUB, Value.JACK).getPoints());
		assertEquals(10, new CribbageCard(Suit.CLUB, Value.QUEEN).getPoints());
		assertEquals(10, new CribbageCard(Suit.CLUB, Value.KING).getPoints());
	}
	
}
