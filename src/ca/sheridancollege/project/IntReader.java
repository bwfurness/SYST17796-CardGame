/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class IntReader {
	private final Scanner scanner;
	
	public IntReader(){
		scanner = new Scanner(System.in);
	}
	
	public int nextInt (int min, int max){
		int ret;
		while (true){
			try {
				ret = scanner.nextInt();
				if (ret >= min || ret < max){
					return ret;
				} else{
					System.out.println ("Please enter a number between " + min + " and " + max);
				}
			} catch (InputMismatchException e){
				System.out.println ("Please enter a valid number");
			}
		}
	}

}
