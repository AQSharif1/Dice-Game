package com.DiceGame;

import java.util.Scanner;

public class Main {
	private static DiceGame diceGame = new DiceGame();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean quit = false;
		int count;
		

		while(!quit) {
			System.out.println("\nMake a choice.");
			menu();
			count = scanner.nextInt();
			scanner.nextLine();
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
					printList();
					break;
				case 5:
					playGame();
					break;
				case 6:
					System.out.println("Game Over.");
					quit = true;
					break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("1---> Add Player");
		System.out.println("2---> Remove Player");
		System.out.println("3---> Check a Players Balance");
		System.out.println("4---> Print Player List");
		System.out.println("5---> Play Game");
		System.out.println("6---> Quit");
	}
	
	public static void addPlayer() {
		System.out.println("Name of player you want to add");
		String name = scanner.nextLine();
		diceGame.addPlayer(name);

	}
	
	public static void removePlayer() {
			System.out.println("Name of player you want to remove");
			String name = scanner.nextLine();
			diceGame.removePlayer(name);
	}
	
	public static void checkBalance() {
		diceGame.currentBalance();
	}
	
	public static void printList() {
		diceGame.printPlayers();
	}
	
	public static void playGame() {
		diceGame.playGame();
		
	}
}
