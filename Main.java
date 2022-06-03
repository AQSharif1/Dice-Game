package com.DiceGame;

import java.util.Scanner;

public class Main {
	private DiceGame diceGame = new DiceGame();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean quit = false;
		int count;
		
		System.out.println("Make a choice.");
		menu();
		count = scanner.nextInt();
		while(!quit) {
			switch(count) {
				case 1:
					addPlayer();
					break;
				case 2: 
					removePlayer();
					break;
				case 3:
					checkBalance();
					break;
				case 4:
					placeBet();
					break;
				case 5:
					printList();
					break;
				case 6:
					playGame();
					break;
				case 7:
					quit = true;
					break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("1---> Add Player");
		System.out.println("2---> Remove Player");
		System.out.println("3---> Check a Players Balance");
		System.out.println("4---> Place bets");
		System.out.println("5---> Print Player List");
		System.out.println("6---> Play Game");
		System.out.println("7---> Quit");
	}
	
	public static void addPlayer() {
		
	}
		
	public static void removePlayer() {
			
	}
	
	public static void checkBalance() {
	}
	
	
	public static void placeBet() {
		
	}
	public static void printList() {
		
	}
	
	public static void playGame() {
		
	}
}
