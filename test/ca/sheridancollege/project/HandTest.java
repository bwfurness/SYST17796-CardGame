/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
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
public class HandTest {
	
	public HandTest() {
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
	 * Test of countPoints method, of class Hand.  May as well test the best hand.
	 */
	@Test
	public void testCountPoints_Starter() {
		System.out.println("countPoints");
		Starter starter = new Starter();
		starter.addCard(new CribbageCard (Suit.SPADE, Value.FIVE));
		Hand instance = new HandImpl();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.JACK));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FIVE));
		instance.addCard(new CribbageCard(Suit.HEART, Value.FIVE));
		instance.addCard(new CribbageCard(Suit.DIAMOND, Value.FIVE));
		int expResult = 29;
		int result = instance.countPoints(starter);
		assertEquals(expResult, result);
	}

	/**
	 * Test of countPoints method, of class Hand.  May as well test 19 too.
	 */
	@Test
	public void testCountPoints_Starter19() {
		System.out.println("countPoints");
		Starter starter = new Starter();
		starter.addCard(new CribbageCard (Suit.SPADE, Value.TWO));
		Hand instance = new HandImpl();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.FOUR));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.SIX));
		instance.addCard(new CribbageCard(Suit.HEART, Value.EIGHT));
		instance.addCard(new CribbageCard(Suit.DIAMOND, Value.TEN));
		int expResult = 0;
		int result = instance.countPoints(starter);
		assertEquals(expResult, result);
	}

	/**
	 * Test of countPoints method, of class Hand.  Going to give the same hand.
	 */
	@Test
	public void testCountPoints_0Arg() {
		System.out.println("countPoints");
		Hand instance = new HandImpl();
		instance.addCard(new CribbageCard(Suit.SPADE, Value.JACK));
		instance.addCard(new CribbageCard(Suit.CLUB, Value.FIVE));
		instance.addCard(new CribbageCard(Suit.HEART, Value.FIVE));
		instance.addCard(new CribbageCard(Suit.DIAMOND, Value.FIVE));
		int expResult = 14;
		int result = instance.countPoints();
		assertEquals(expResult, result);
	}

	/**
	 * Test of count15 method, of class Hand.
	 */
	@Test
	public void testCount15_List() {
		System.out.println("count15");
		List<CribbageCard> cards = new ArrayList<>();
		cards.add(new CribbageCard(Suit.SPADE, Value.JACK));
		cards.add(new CribbageCard(Suit.CLUB, Value.FIVE));
		cards.add(new CribbageCard(Suit.HEART, Value.FIVE));
		cards.add(new CribbageCard(Suit.DIAMOND, Value.FIVE));
		cards.add(new CribbageCard(Suit.SPADE, Value.FIVE));
		Hand instance = new HandImpl();
		int expResult = 16;
		int result = instance.count15(cards);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of pair method, of class Hand.
	 */
	@Test
	public void testPair() {
		System.out.println("pair");
		List<CribbageCard> cards = new ArrayList<>();
		cards.add(new CribbageCard(Suit.SPADE, Value.JACK));
		cards.add(new CribbageCard(Suit.CLUB, Value.FIVE));
		cards.add(new CribbageCard(Suit.HEART, Value.FIVE));
		cards.add(new CribbageCard(Suit.DIAMOND, Value.FIVE));
		cards.add(new CribbageCard(Suit.SPADE, Value.FIVE));
		Hand instance = new HandImpl();
		int expResult = 12;
		int result = instance.pair(cards);
		assertEquals(expResult, result);
	}

	/**
	 * Test of run method, of class Hand.
	 */
	@Test
	public void testRun_List() {
		System.out.println("run");
		List<CribbageCard> cards = new ArrayList<>();
		cards.add(new CribbageCard(Suit.SPADE, Value.ACE));
		cards.add(new CribbageCard(Suit.CLUB, Value.TWO));
		cards.add(new CribbageCard(Suit.HEART, Value.THREE));
		cards.add(new CribbageCard(Suit.DIAMOND, Value.FOUR));
		cards.add(new CribbageCard(Suit.SPADE, Value.FIVE));
		Hand instance = new HandImpl();
		int expResult = 5;
		int result = instance.run(cards);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of run method, of class Hand.
	 */
	@Test
	public void testRun_ListMulti() {
		System.out.println("run");
		List<CribbageCard> cards = new ArrayList<>();
		cards.add(new CribbageCard(Suit.SPADE, Value.ACE));
		cards.add(new CribbageCard(Suit.CLUB, Value.TWO));
		cards.add(new CribbageCard(Suit.HEART, Value.TWO));
		cards.add(new CribbageCard(Suit.DIAMOND, Value.THREE));
		cards.add(new CribbageCard(Suit.SPADE, Value.THREE));
		Hand instance = new HandImpl();
		int expResult = 12;
		int result = instance.run(cards);
		assertEquals(expResult, result);
	}



	public class HandImpl extends Hand {

		public int flush(CribbageCard starter) {
			return 0;
		}
	}
	
}
