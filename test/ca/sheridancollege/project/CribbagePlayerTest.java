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
public class CribbagePlayerTest {
	
	public CribbagePlayerTest() {
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
	 * Test of score method, of class CribbagePlayer.
	 */
	@Test
	public void testScoreGood() {
		System.out.println("score");
		int points = 125;
		CribbagePlayer instance = new CribbagePlayerImpl();
		boolean expResult = true;
		boolean result = instance.score(points);
		assertEquals(expResult, result);
	}

	/**
	 * Test of score method, of class CribbagePlayer.  Taking Bad as meaning not won.
	 */
	@Test
	public void testScoreBad() {
		System.out.println("score");
		int points = 100;
		CribbagePlayer instance = new CribbagePlayerImpl();
		boolean expResult = false;
		boolean result = instance.score(points);
		assertEquals(expResult, result);
	}

	
	/**
	 * Test of score method, of class CribbagePlayer.
	 */
	@Test
	public void testScoreBoundary() {
		System.out.println("score");
		int points = 120;
		CribbagePlayer instance = new CribbagePlayerImpl();
		boolean expResult = false;
		boolean result = instance.score(points);
		assertEquals(expResult, result);
		expResult = true;
		result = instance.score(1);
		assertEquals(expResult, result);
	}


	/**
	 * Test of won method, of class CribbagePlayer.  Again taking "bad" as returning false.
	 */
	@Test
	public void testWonGood() {
		System.out.println("won");
		CribbagePlayer instance = new CribbagePlayerImpl();
		instance.score(150);
		boolean expResult = true;
		boolean result = instance.won();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of won method, of class CribbagePlayer.  Again taking "bad" as returning false.
	 */
	@Test
	public void testWonBad() {
		System.out.println("won");
		CribbagePlayer instance = new CribbagePlayerImpl();;
		boolean expResult = false;
		boolean result = instance.won();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of won method, of class CribbagePlayer.  Again taking "bad" as returning false.
	 */
	@Test
	public void testWonBundary() {
		System.out.println("won");
		CribbagePlayer instance = new CribbagePlayerImpl();
		instance.score(120);
		boolean expResult = false;
		boolean result = instance.won();
		assertEquals(expResult, result);
		instance.score(1);
		expResult = true;
		result = instance.won();
		assertEquals(expResult, result);
	}

	/**
	 * Test of skunked method, of class CribbagePlayer.
	 */
	@Test
	public void testSkunkedGood() {
		System.out.println("skunked");
		CribbagePlayer instance = new CribbagePlayerImpl();
		boolean expResult = true;
		boolean result = instance.skunked();
		assertEquals(expResult, result);
	}


	/**
	 * Test of skunked method, of class CribbagePlayer.
	 */
	@Test
	public void testSkunkedBad() {
		System.out.println("skunked");
		CribbagePlayer instance = new CribbagePlayerImpl();
		instance.score(95);
		boolean expResult = false;
		boolean result = instance.skunked();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of skunked method, of class CribbagePlayer.
	 */
	@Test
	public void testSkunkedBoundary() {
		System.out.println("skunked");
		CribbagePlayer instance = new CribbagePlayerImpl();
		instance.score(90);
		boolean expResult = true;
		boolean result = instance.skunked();
		assertEquals(expResult, result);
		instance.score(1);
		expResult = false;
		result = instance.skunked();
		assertEquals(expResult, result);
	}

	public class CribbagePlayerImpl extends CribbagePlayer {

		public CribbagePlayerImpl() {
			super("", null);
		}

		public void preplay() {
		}

		public boolean peg() {
			return false;
		}
	}
	
}
