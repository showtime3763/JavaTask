package Gamesource.character.hero;

import java.util.Scanner;

import Gamesource.character.Character;
import Gamesource.character.monster.Monster;
import Gamesource.map.Mission;

public abstract class Hero extends Character {
	public int experience;
	public int money;
	protected String job;
	public String Skill1;
	public String Skill2;
	public String BasicWP;
	public String StrongWP;
	public String UltimateWP;

	public Hero(String name) {
		super(name);
	}

	public static Hero chooseJob(String name, Scanner sc) {
		System.out.println("직업 선택: 1) 전사 2) 마법사 3) 궁수 4) 도적");
		int j = sc.nextInt();
		sc.nextLine();
		Hero selectedHero;
		switch (j) {
		case 1:
			selectedHero = new Warrior(name);
			break;
		case 2:
			selectedHero = new Mage(name);
			break;
		case 3:
			selectedHero = new Archer(name);
			break;
		case 4:
			selectedHero = new Thief(name);
			break;
		default:
			selectedHero = new Warrior(name);
			break;
		}
		selectedHero.experience = 0;
		selectedHero.money = 100;
		System.out.println(selectedHero.job + " 선택!\n 능력치\n HP:" + selectedHero.hp + "\n Power:" + selectedHero.power
				+ "\n Def:" + selectedHero.defense + "\n MP:" + selectedHero.mp);
		return selectedHero;
	}

	public void showAttacks() {
		System.out.println("1) 기본 공격");
		if (level >= 3)
			System.out.println("2) 강화 공격 : " + this.Skill1);
		if (level >= 5)
			System.out.println("3) 스킬 : " + this.Skill2);
	}

	public int attack(Character target, int choice) {
		int damage;
		switch (choice) {
		case 1:
			damage = power * level + 10;
			break;
		case 2:
			if (level >= 3 && mp >= 10) {
				damage = useSpecialSkill(target);
				mp -= 10;
			} else {
				System.out.println("공격을 사용할 수 없습니다.");
				return 0;
			}
			break;
		case 3:
			if (level >= 5 && mp >= 25) {
				damage = useUltimateSkill(target);
				mp -= 25;
			} else {
				System.out.println("공격을 사용할 수 없습니다.");
				return 0;
			}
			break;
		default:
			System.out.println("선택할 수 없습니다.");
			return 0;
		}
		target.hp -= Math.max(0, damage - target.defense);
		return damage;
	}

	@Override
	public int attack(Character target) {
		return attack(target, 1);
	}

	public void gainRewards(Monster m) {
		experience += m.getExperience();
		money += m.getMoney();
		System.out.println("경험치 " + m.getExperience() + " EXP 와 " + m.getMoney() + " 골드를 얻었습니다!");
	}

	public void checkLevelUp() {
		if (experience >= level * 50) {
			level++;
			experience = 0;
			money += level * 50;
			System.out.println("레벨 업! 레벨 " + level + "! 추가 골드 보상.");
			Mission.assign(this);
		}
	}

	public void revive() {
		hp = 1;
	}

	public int getExperience() {
		return experience;
	}

	public int getMoney() {
		return money;
	}

	public String getJob() {
		return job;
	}

	// 고유 스킬 추상 메소드
	protected abstract int useSpecialSkill(Character target);

	protected abstract int useUltimateSkill(Character target);
}
