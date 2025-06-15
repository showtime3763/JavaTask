package Gamesource.map;

import java.util.Scanner;

import Gamesource.character.hero.Hero;

public class WeaponStore {
	public static void visit(Hero hero, Scanner sc) {
		System.out.println("-- 무기 상점 --");
		System.out.printf("1) %d (무료) 2) %d (50골드) 3) %d (100골드) \n", hero.BasicWP, hero.StrongWP, hero.UltimateWP);
		int w = sc.nextInt();
		sc.nextLine();
		if (w == 2 && hero.getMoney() >= 50) {
			hero.power += 5;
			hero.money -= 50;
			System.out.println("중급 무기 장비됨.");
		} else if (w == 3 && hero.getMoney() >= 100) {
			hero.power += 10;
			hero.money -= 100;
			System.out.println("상급 무기 장비됨.");
		} else
			System.out.println("기본 무기 장비됨.");
	}
}
