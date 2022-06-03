package com.DiceGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame {
	private List<Player> players; //List of players
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Constructor
	 */
	public DiceGame() {
		this.players = new ArrayList<>();
	}
	
	/**
	 * Add a player
	 * @param name
	 * @return boolean 
	 */
	public boolean addPlayer(String name) {
		for(Player p : players)
		if(p.getName().equalsIgnoreCase(name)){
			System.out.println("Player already playing.\n");
			return false;
		}
		Player newPlayer = new Player(name);
		players.add(newPlayer);
		System.out.println(name + " added.");
		return true;
	}
	/**
	 * Removes player
	 * @param name
	 * @return boolean
	 */
	public boolean removePlayer(String name) {
		for(int i = 0; i<players.size(); i++) {
			if(players.get(i).getName().equalsIgnoreCase(name)) {
				players.remove(i);
				System.out.println(name + " removed");
				return true;
			}
		}System.out.println("Player " + name + " not playing");
		return false;
	}
	
	/**
	 * Get Player current balance
	 */
	public void currentBalance() {
		System.out.println("Which players Balance do you want to check? ");
		String name = scanner.nextLine();
		for(int i = 0; i<players.size();i++) {
			if(players.get(i).getName().equalsIgnoreCase(name)) {
				System.out.println(name + " Current balance: "+ players.get(i).getMoney() +"\n");
				return;
			}
		}
		System.out.println(name + " Not playing.\n");
	}
	
	/**
	 * Place bet amount
	 */
	public double betPlaced() {
		double bet = 0;
		for(int i = 0; i<players.size();i++) {
		System.out.println(players.get(i).getName() + " How much are you betting?");
		 bet = scanner.nextDouble();
		while(bet> players.get(i).getMoney()) {
			System.out.println(" Current balance: "+ players.get(i).getMoney() + " Insufficent amount, bet a lesser amount");
			bet = scanner.nextDouble();
		}
		if(bet<= players.get(i).getMoney()) {
			players.get(i).setMoney(players.get(i).getMoney() - bet);
			System.out.println(players.get(i).getName() + " Bet: " + bet);
			}
		
		}
		return bet;
	}
	/**
	 * Print list of players
	 */
	public void printPlayers() {
		for(Player p : players) {
			System.out.println(p.getName() + " " + p.getMoney());
		}
	}
	
	/*
	 * public void playGame() { double bet = betPlaced(); for(int i = 0; i<
	 * players.size();i++) { if(players.get(i).getDice1()+players.get(i).getDice2()
	 * == 2) { System.out.println("Snake eye! ");
	 * 
	 * } } }
	 */
}
