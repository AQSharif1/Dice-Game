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
		for(Player p : players) {
		if(p.getName().equalsIgnoreCase(name)){
			System.out.println("Player already playing.\n");
			return false;
		}
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
	public void betPlaced() {
		
		for(int i = 0; i<players.size();i++) {
		System.out.println(players.get(i).getName() + " How much are you betting?");
		 players.get(i).setBet(scanner.nextDouble());
		 scanner.nextLine();
		while(players.get(i).getBet()> players.get(i).getMoney()) {
			System.out.println(" Current balance: "+ players.get(i).getMoney() + " Insufficent amount, bet a lesser amount");
			 players.get(i).setBet(scanner.nextDouble());
			scanner.nextLine();
		}
		if(players.get(i).getBet()<= players.get(i).getMoney()) {
			players.get(i).setMoney(players.get(i).getMoney() -players.get(i).getBet() );
			System.out.println(players.get(i).getName() + " Bet: " + players.get(i).getBet());
			}
		//players.get(i).setMoney(players.get(i).getMoney() - bet);
		}
		
	}
	/**
	 * Print list of players
	 */
	public void printPlayers() {
		for(Player p : players) {
			System.out.println(p.getName() + " ----> Balance: " + p.getMoney());
		}
	}
	
	public void diceRolls() {
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " Dice 1: "+ players.get(i).getDice1() + " Dice 2: " +
		players.get(i).getDice2() + "\nScore: " + players.get(i).getScore() + "\n");
		}
	}
	
	
	  public void playGame() {
		  int max = Integer.MAX_VALUE;
		  Player winningPlayer = players.get(1);
		  if(players.size() < 2) {
			  System.out.println(players.size() + " Players, not Enough players Add more players!");
		  }else
		  betPlaced();
		  diceRolls();
		  for(int i = 0; i< players.size() -1 ;i++) {
			 if(players.get(i).getScore() > players.get(i+1).getScore()) {
				// max = players.get(i).getScore();
				  winningPlayer = players.get(i);
			 }
			 if(players.get(i).getScore() ==players.get(i+1).getScore()) {
				 System.out.println("Tie!");
				 return;
			 }
		  	}
		  	winningPlayer.setMoney(winningPlayer.getMoney() + (winningPlayer.getBet()*2));
		  	System.out.println("Winner: " + winningPlayer.getName());
		  	System.out.println(winningPlayer.getName() + "---> Balance: " + winningPlayer.getMoney());
		  }
	 
}
