package com.DiceGame;

public class Player {
	private String name;
	private  double money = 1000;
	private double bet;
	private int dice1= (int) (Math.random()*6 +1);
	private int dice2 = (int) (Math.random()*6 +1);
	private int  Score = dice1 + dice2;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getBet() {
		return bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}

	public int getDice1() {
		return dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public int getScore() {
		return Score;
	}
	
	
	
	

}
