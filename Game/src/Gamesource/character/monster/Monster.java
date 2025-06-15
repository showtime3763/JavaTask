package Gamesource.character.monster;

import java.util.Scanner;

import Gamesource.character.Character;

public class Monster extends Character {
	private int experience;
	private int money;

	public Monster(String name, int lv, int hp, int power, int def, int exp, int gold) {
		super(name);
		this.level = lv;
		this.hp = hp;
		this.power = power;
		this.defense = def;
		this.experience = exp;
		this.money = gold;
	}

	public static Monster selectMonster(Scanner sc) {
		System.out.println("1) 너구리 Lv1  2) 살쾡이 Lv3  3) 들개 Lv5  4) 늑대 Lv10");
		int m = sc.nextInt();
		sc.nextLine();
		switch (m) {
		case 1:
			return new Monster("너구리", 1, 50, 20, 5, 30, 10);
		case 2:
			return new Monster("살쾡이", 3, 100, 25, 4, 50, 30);
		case 3:
			return new Monster("들개", 5, 200, 30, 6, 100, 50);
		default:
			return new Monster("늑대", 10, 400, 35, 10, 300, 200);
		}
	}

	@Override
	public int attack(Character target) {
		target.hp -= Math.max(0, power - target.defense);
		return power;
	}

	public int getExperience() {
		return experience;
	}

	public int getMoney() {
		return money;
	}
}
